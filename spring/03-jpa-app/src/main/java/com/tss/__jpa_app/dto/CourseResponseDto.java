package com.tss.__jpa_app.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CourseResponseDto {
    private Long courseId;
    private String courseName;
    private Integer duration;
    private Double fees;
}
