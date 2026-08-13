package com.tss.__jpa_app.repository;

import com.tss.__jpa_app.entity.OtpVerification;
import com.tss.__jpa_app.enums.Purpose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OtpVerificationRepository extends JpaRepository<OtpVerification,Long> {

    Optional<OtpVerification> findTopByDestinationAndPurposeOrderByCreatedAtDesc(
            String destination,
            Purpose purpose
    );
}
