package com.tss.__jpa_app.mapping;

import com.tss.__jpa_app.dto.CourseRequestDto;
import com.tss.__jpa_app.dto.CourseResponseDto;
import com.tss.__jpa_app.dto.StudentRequestDto;
import com.tss.__jpa_app.dto.StudentResponseDto;
import com.tss.__jpa_app.entity.Course;
import com.tss.__jpa_app.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapping {
    Course dtoToCourse(CourseRequestDto dto);
    CourseResponseDto courseToCourseResponseDto(Course course);
}
