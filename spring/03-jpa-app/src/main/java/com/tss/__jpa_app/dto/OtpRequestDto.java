package com.tss.__jpa_app.dto;

import com.tss.__jpa_app.enums.Chanel;
import com.tss.__jpa_app.enums.Purpose;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OtpRequestDto {
    @NotBlank(message = "Destination is required")
    private String destination;

    @NotNull(message = "Channel is required")
    private Chanel chanel;

    @NotNull(message = "Purpose is required")
    private Purpose purpose;

    @AssertTrue(message = "Please enter a valid email address")
    public boolean isValidEmail() {

        if (chanel != Chanel.EMAIL) {
            return true; // skip validation for SMS
        }

        return destination != null && destination.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }


    @AssertTrue(message = "Please enter a valid 10 digit mobile number")
    public boolean isValidMobile() {
        if (chanel != Chanel.SMS) {
            return true; // skip validation for EMAIL
        }
        return destination != null && destination.matches("^\\d{10}$");
    }
}
