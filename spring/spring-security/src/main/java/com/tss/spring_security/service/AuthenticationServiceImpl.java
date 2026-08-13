package com.tss.spring_security.service;

import com.tss.spring_security.dto.LoginDto;
import com.tss.spring_security.dto.RegistrationDto;
import com.tss.spring_security.dto.UserResponseDto;
import com.tss.spring_security.entity.Role;
import com.tss.spring_security.entity.User;
import com.tss.spring_security.repository.RoleRepository;
import com.tss.spring_security.repository.UserRepository;
import com.tss.spring_security.security.JwtTokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.PasswordAuthentication;

@AllArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService{
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    @Override
    public UserResponseDto register(RegistrationDto registrationDto) {
        if (userRepository.existsByUserName(registrationDto.getUserName()))
            throw new RuntimeException("User not found");

        User user = new User();
        user.setUserName(registrationDto.getUserName());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));

        Role userRole =roleRepository.findByRoleName(registrationDto.getRole())
                .orElseThrow(()-> new RuntimeException("Role does not exists"));
                        userRole.getUsers().add(user);
        user.setRole(userRole);
        user = userRepository.save(user);
        UserResponseDto dto = new UserResponseDto();
        dto.setUserId(user.getUserId());
        dto.setUserName(user.getUserName());
        return dto;
    }

    @Override
    public String login (LoginDto loginDto) {
        try {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUserName(), loginDto.getPassword()));
        //SecurityContextHolder getContext().setAuthentication(authentication);

            String token = jwtTokenProvider.generateToken(authentication);
        return token;
    } catch (BadCredentialsException e) {
            throw new RuntimeException( "Username or Password is incorrect");
        }
    }
}
