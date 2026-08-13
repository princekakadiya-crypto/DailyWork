package com.tss.__jpa_app.dto;

import com.tss.__jpa_app.enums.Purpose;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VerifyOtpRequestDto {
    @NotBlank(message = "Destination is required")
    private String destination;

    @NotBlank(message = "OTP is required")
    private String otp;

    @NotNull(message = "Purpose is required")
    private Purpose purpose;
}
