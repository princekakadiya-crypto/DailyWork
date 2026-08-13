package com.tss.__jpa_app.controller;

import com.tss.__jpa_app.dto.OtpRequestDto;
import com.tss.__jpa_app.dto.OtpResponseDto;
import com.tss.__jpa_app.dto.VerifyOtpRequestDto;
import com.tss.__jpa_app.service.OtpService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app/otp")
public class OtpController {
    private final OtpService otpService;

    @PostMapping("/send")
    public ResponseEntity<OtpResponseDto> sendOtp(@Valid @RequestBody OtpRequestDto request) {

        return ResponseEntity.ok(
                otpService.sendOtp(request)
        );
    }

    @PostMapping("/verify")
    public ResponseEntity<Boolean> verifyOtp(@Valid @RequestBody VerifyOtpRequestDto request) {

        return ResponseEntity.ok(
                otpService.verifyOtp(request)
        );
    }
}
