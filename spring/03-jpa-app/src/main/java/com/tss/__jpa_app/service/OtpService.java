package com.tss.__jpa_app.service;

import com.tss.__jpa_app.dto.OtpRequestDto;
import com.tss.__jpa_app.dto.OtpResponseDto;
import com.tss.__jpa_app.dto.VerifyOtpRequestDto;

public interface OtpService {
    OtpResponseDto sendOtp(OtpRequestDto request);

    boolean verifyOtp(VerifyOtpRequestDto request);
}
