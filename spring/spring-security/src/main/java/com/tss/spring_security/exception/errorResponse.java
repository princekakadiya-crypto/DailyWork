package com.tss.spring_security.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class errorResponse {
    private Integer code;
    private String errorMessage;
    private LocalDateTime errorTime;
}
