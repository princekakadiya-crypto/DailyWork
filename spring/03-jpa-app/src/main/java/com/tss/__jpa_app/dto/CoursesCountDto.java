package com.tss.__jpa_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoursesCountDto {
    private String instructorName;
    private Long courseCount;
}
