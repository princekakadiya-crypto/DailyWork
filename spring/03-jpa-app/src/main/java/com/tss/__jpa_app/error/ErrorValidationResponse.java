package com.tss.__jpa_app.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@AllArgsConstructor
public class ErrorValidationResponse {
    private Integer code;
    private String errorMessage;
    private LocalDateTime errorTime;
    private Map<String,String> errors;
}
