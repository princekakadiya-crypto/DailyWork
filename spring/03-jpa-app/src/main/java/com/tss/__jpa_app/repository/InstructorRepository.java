package com.tss.__jpa_app.repository;

import com.tss.__jpa_app.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor,Long> {
    boolean existsByInstructorId(Long instructorId);
}
