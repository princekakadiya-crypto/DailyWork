package com.tss.spring_security.dto;

import lombok.Data;

@Data
public class RegistrationDto {
    private String userName;
    private String password;
    private String role;
}
