package com.tss.__jpa_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AssignCoursesRequest {
    private List<Long> courseIds;
}
