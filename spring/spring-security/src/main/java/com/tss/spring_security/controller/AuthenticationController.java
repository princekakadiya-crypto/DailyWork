package com.tss.spring_security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import com.tss.spring_security.dto.LoginDto;
import com.tss.spring_security.dto.RegistrationDto;
import com.tss.spring_security.dto.UserResponseDto;
import com.tss.spring_security.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(@RequestBody RegistrationDto registrationDto) {

        UserResponseDto response = authenticationService.register(registrationDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {

        String token = authenticationService.login(loginDto);
        return ResponseEntity.ok(token);
    }
}
