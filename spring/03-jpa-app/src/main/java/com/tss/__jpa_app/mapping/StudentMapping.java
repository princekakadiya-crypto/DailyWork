package com.tss.__jpa_app.mapping;

import com.tss.__jpa_app.dto.StudentRequestDto;
import com.tss.__jpa_app.dto.StudentResponseDto;
import com.tss.__jpa_app.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapping {
    Student dtoToStudent(StudentRequestDto dto);
    StudentResponseDto studentToStudentResponseDto(Student student);
}
