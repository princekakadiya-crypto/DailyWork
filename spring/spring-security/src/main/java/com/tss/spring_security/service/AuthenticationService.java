package com.tss.spring_security.service;

import com.tss.spring_security.dto.LoginDto;
import com.tss.spring_security.dto.RegistrationDto;
import com.tss.spring_security.dto.UserResponseDto;

public interface AuthenticationService {
    UserResponseDto register(RegistrationDto registrationDto);
    String login(LoginDto loginDto);
}
