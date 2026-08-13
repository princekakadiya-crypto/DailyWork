package com.tss.__jpa_app.service;

import com.tss.__jpa_app.dto.OtpRequestDto;
import com.tss.__jpa_app.dto.OtpResponseDto;
import com.tss.__jpa_app.dto.VerifyOtpRequestDto;
import com.tss.__jpa_app.entity.OtpVerification;
import com.tss.__jpa_app.exception.InvalidOtpException;
import com.tss.__jpa_app.exception.NotFoundException;
import com.tss.__jpa_app.exception.OtpAlreadyUsedException;
import com.tss.__jpa_app.exception.OtpExpiredException;
import com.tss.__jpa_app.repository.OtpVerificationRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class OtpServiceImpl implements OtpService{

    private final OtpVerificationRepository otpVerificationRepository;
    private final NotificationProcessor notificationProcessor;

    private static final Logger log= LoggerFactory.getLogger(OtpServiceImpl.class);

    @Override
    @Transactional
    public OtpResponseDto sendOtp(OtpRequestDto request) {

        log.info("sending otp to destination : "+request.getDestination());
        String otp = generateOtp();

        OtpVerification otpVerification = new OtpVerification();
        otpVerification.setDestination(request.getDestination());
        otpVerification.setOtp(otp);
        otpVerification.setChanel(request.getChanel());
        otpVerification.setPurpose(request.getPurpose());
        otpVerification.setExpiresAt(LocalDateTime.now().plusMinutes(5));

        otpVerificationRepository.save(otpVerification);
        log.info("otp entry saved in database with destination : "+request.getDestination());
        notificationProcessor.send(request.getChanel(),"OTP : "+otp,request.getDestination());

        log.info("otp message delivered to destination : "+request.getDestination());

        return new OtpResponseDto("OTP sent successfully", otpVerification.getExpiresAt());
    }

    @Override
    public boolean verifyOtp(VerifyOtpRequestDto request) {
        log.info("verifying otp for destination : "+request.getDestination());

        OtpVerification otp = otpVerificationRepository.findTopByDestinationAndPurposeOrderByCreatedAtDesc(
                request.getDestination(), request.getPurpose())
                .orElseThrow(() -> new NotFoundException("OTP not found"));

        if (otp.isVerified()) {
            log.warn("OTP expired for destination: "+ otp.getDestination());

            throw new OtpExpiredException("OTP has expired. Please request a new OTP.");
        }

        if (otp.getExpiresAt().isBefore(LocalDateTime.now())) {
            log.warn("Attempt to use already verified OTP. Destination: "+ otp.getDestination());

            throw new OtpAlreadyUsedException("OTP has already been used.");
        }

        if (!otp.getOtp().equals(request.getOtp())) {
            log.warn("Invalid OTP entered for destination: "+ request.getDestination());

            throw new InvalidOtpException("Invalid OTP. Please enter the correct OTP.");
        }

        otp.setVerified(true);
        otpVerificationRepository.save(otp);

        log.info("otp verify successfully for destination : "+ request.getDestination());

        return true;
    }

    private String generateOtp() {

        SecureRandom random = new SecureRandom();
        int number = random.nextInt(900000) + 100000;
        return String.valueOf(number);
    }
}
