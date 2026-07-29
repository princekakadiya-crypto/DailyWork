package com.tss.__jpa_app.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class StudentResponseDto {
    private Long id;
    private String name;
}
