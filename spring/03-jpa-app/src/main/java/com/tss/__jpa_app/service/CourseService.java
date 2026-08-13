package com.tss.__jpa_app.service;

import com.tss.__jpa_app.dto.*;

import java.util.List;

public interface CourseService {
    CourseResponseDto addCourse(CourseRequestDto courseRequestDto);
    PageDto getAllCourse(int page, int size);

    InstructorResponseDto getInstructorByCourseId(Long courseId);

    void assignCourse(Long courseId,Long instructorId);

    void assignStudents(Long courseId, AssignStudentsRequest studentsRequest);

    List<StudentResponseDto> getStudentByCourseId(Long courseId);
}
