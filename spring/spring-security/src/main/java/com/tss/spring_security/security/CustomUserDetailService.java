package com.tss.spring_security.security;

import com.tss.spring_security.entity.Role;
import com.tss.spring_security.entity.User;
import com.tss.spring_security.repository.UserRepository;
import jakarta.persistence.SecondaryTable;
import lombok.AllArgsConstructor;
import org.springframework.boot.security.autoconfigure.SecurityProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByUserName(username).orElseThrow(
                ()->new RuntimeException("User Not Found")
        );

        Role role=user.getRole();

        Set<GrantedAuthority> authorities=new HashSet<>();

        SimpleGrantedAuthority authority=new SimpleGrantedAuthority(role.getRoleName());
        authorities.add(authority);

        return new org.springframework.security.core.userdetails.User(user.getUserName(),
                user.getPassword(),authorities);

    }
}
