package com.tss.__jpa_app.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class EmployeeRequestDto {
    private String name;
    private String department;
}
