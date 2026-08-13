package com.tss.__jpa_app.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentRequestDto {
    @NotNull(message = "name is required")
    @NotEmpty(message = "name is required")
    private String name;
    @NotNull(message = "age is required")
    @PositiveOrZero(message = "age can not be negative")
    private Integer age;

    private String city;
    private String state;
    private String pincode;
}
