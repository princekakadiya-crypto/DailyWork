package com.tss.__jpa_app.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AddressRequestDto {
    @NotBlank(message = "City required")
    private String city;
    @NotBlank(message = "State required")
    private String state;
    @NotBlank(message = "pincode required")
    private String pincode;
}
