package com.tss.__jpa_app.service;

import com.tss.__jpa_app.dto.PageDto;
import com.tss.__jpa_app.dto.StudentRequestDto;
import com.tss.__jpa_app.dto.StudentResponseDto;
import com.tss.__jpa_app.entity.Student;
import com.tss.__jpa_app.exception.StudentNotFoundException;
import com.tss.__jpa_app.mapping.StudentMapping;
import com.tss.__jpa_app.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;
    private final StudentMapping studentMapping;

    @Override
    public PageDto<StudentResponseDto> getAllStudent(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Student> students = studentRepository.findAll(pageable);
        List<StudentResponseDto> responseDtos = new ArrayList<>();

        for (Student student : students.getContent()) {
            StudentResponseDto dto = studentMapping.studentToStudentResponseDto(student);
            responseDtos.add(dto);
        }

        PageDto<StudentResponseDto> pageDto=new PageDto<>();
        pageDto.setContent(responseDtos);
        pageDto.setEmpty(students.isEmpty());
        pageDto.setFirst(students.isFirst());
        pageDto.setLast(students.isLast());
        pageDto.setTotalPages(students.getTotalPages());
        pageDto.setTotalElement(students.getTotalElements());

        return pageDto;
    }

    @Override
    public StudentResponseDto getStudentById(Long id) {

        Student result= studentRepository.findById(id).orElseThrow(
                ()-> new StudentNotFoundException(id)
        );
        return studentMapping.studentToStudentResponseDto(result);
    }

    public StudentResponseDto addStudent(StudentRequestDto dto) {
        Student student=studentMapping.studentRequestDtoToStudent(dto);
        Student result= studentRepository.save(student);
        return studentMapping.studentToStudentResponseDto(result);
    }

//    private Student studentRequestDtoToStudent(StudentRequestDto dto){
//        Student student=new Student();
//        student.setName(dto.getName());
//        student.setAge(dto.getAge());
//        return student;
//    }
//
//    private StudentResponseDto studentToStudentResponseDto(Student student){
//        StudentResponseDto responseDto=new StudentResponseDto();
//        responseDto.setId(student.getId());
//        responseDto.setName(student.getName());
//        return responseDto;
//    }

}
