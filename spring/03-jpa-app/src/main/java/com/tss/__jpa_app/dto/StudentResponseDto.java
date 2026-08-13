package com.tss.__jpa_app.dto;

import com.tss.__jpa_app.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentResponseDto {
    private Long StudentId;
    private String name;
}
