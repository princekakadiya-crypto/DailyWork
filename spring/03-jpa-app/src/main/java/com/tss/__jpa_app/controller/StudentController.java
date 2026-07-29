package com.tss.__jpa_app.controller;

import com.tss.__jpa_app.dto.PageDto;
import com.tss.__jpa_app.dto.StudentRequestDto;
import com.tss.__jpa_app.dto.StudentResponseDto;
import com.tss.__jpa_app.service.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app")
public class StudentController {

    private final StudentServiceImpl studentService;

    @GetMapping("/students")
    public ResponseEntity<PageDto<StudentResponseDto>> getStudents(@RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "2") int size){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Application", "Student Management");
        headers.add("Version", "1.0");

        return new ResponseEntity<>(
                studentService.getAllStudent(page, size),
                headers,
                HttpStatus.OK
        );
    }

    @GetMapping("students/{id}")
    public ResponseEntity<StudentResponseDto> getStudent(@PathVariable Long id){
        return new ResponseEntity<>(studentService.getStudentById(id),HttpStatus.OK);
    }


    @PostMapping("students")
    public ResponseEntity<StudentResponseDto> addStudent(@RequestBody StudentRequestDto student){
        return new ResponseEntity<>(studentService.addStudent(student),HttpStatus.CREATED);
    }
}
