package com.tss.spring_security.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserResponseDto {
    private Long userId;
    private String userName;
}
