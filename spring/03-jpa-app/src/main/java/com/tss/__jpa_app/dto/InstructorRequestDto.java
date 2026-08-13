package com.tss.__jpa_app.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InstructorRequestDto {
    private String instructorName;
    private String designation;
}
