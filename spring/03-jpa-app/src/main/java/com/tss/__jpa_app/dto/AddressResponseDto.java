package com.tss.__jpa_app.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddressResponseDto {
    private Long AddressId;
    private String city;
    private String state;
    private String pincode;
}
