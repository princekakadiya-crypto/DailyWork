package com.tss.__jpa_app.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class EmployeeResponseDto {
    private Long id;
    private String name;
}
