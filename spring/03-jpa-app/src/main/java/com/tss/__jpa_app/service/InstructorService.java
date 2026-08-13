package com.tss.__jpa_app.service;

import com.tss.__jpa_app.dto.*;

import java.util.List;

public interface InstructorService {
    InstructorResponseDto addInstructor(InstructorRequestDto instructorRequestDto);
    PageDto getAllInstructor(int page, int size);
    void assignCourse(Long instructorId,Long courseId);
    List<CourseResponseDto> getCourseByInstructorId(Long instructorId);

    Long getCourseCountByInstructor(Long instructorId);

    List<CoursesCountDto> getCoursesCount();

    boolean canDeleteInstructor(Long instructorId);
}
