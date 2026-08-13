package com.tss.__jpa_app.service;

import com.tss.__jpa_app.dto.*;
import org.springframework.http.HttpHeaders;

import java.util.List;

public interface StudentService {
    PageDto getAllStudent(int page, int size);

    StudentResponseDto getStudentById(Long id);

    StudentResponseDto addStudent(StudentRequestDto student);

    Integer deleteByAge(Integer age);

    AddressResponseDto getAddressByStudentId(Long studentId);

    StudentResponseDto addAddress(Long studentId, AddressRequestDto addRequestDto);

    StudentResponseDto editAddress(Long studentId, AddressRequestDto addRequestDto);

    void assignCourse(Long studentId, Long courseId);

    void assignCourses(Long studentId, AssignCoursesRequest studentsRequest);

    List<CourseResponseDto> getCourseByStudentId(Long studentId);
}
