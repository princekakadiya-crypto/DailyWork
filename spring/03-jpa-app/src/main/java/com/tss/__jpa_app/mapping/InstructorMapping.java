package com.tss.__jpa_app.mapping;

import com.tss.__jpa_app.dto.CourseRequestDto;
import com.tss.__jpa_app.dto.CourseResponseDto;
import com.tss.__jpa_app.dto.InstructorRequestDto;
import com.tss.__jpa_app.dto.InstructorResponseDto;
import com.tss.__jpa_app.entity.Course;
import com.tss.__jpa_app.entity.Instructor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InstructorMapping {
    Instructor dtoToInstructor(InstructorRequestDto dto);
    InstructorResponseDto instructorToInstructorResponseDto(Instructor instructor);
}
