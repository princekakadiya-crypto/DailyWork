package com.tss.__jpa_app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class OtpResponseDto {
    private String message;

    private LocalDateTime expiresAt;
}
