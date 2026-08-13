package com.tss.__jpa_app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDto {
    @NotBlank(message = "Employee name is required")
    @Size(min = 3, max = 50, message = "Employee name must be between 3 and 50 characters")
    private String name;

    @NotBlank(message = "Department is required")
    @Size(min = 2, max = 50, message = "Department must be between 2 and 50 characters")
    private String department;

    @NotNull(message = "Image is required")
    private MultipartFile image;
}
