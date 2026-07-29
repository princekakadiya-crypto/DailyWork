package com.tss.__jpa_app.service;

import com.tss.__jpa_app.dto.PageDto;
import com.tss.__jpa_app.dto.StudentRequestDto;
import com.tss.__jpa_app.dto.StudentResponseDto;
import com.tss.__jpa_app.entity.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {
    PageDto getAllStudent(int page, int size);

    StudentResponseDto getStudentById(Long id);

    StudentResponseDto addStudent(StudentRequestDto student);
}
