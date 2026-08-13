package com.tss.__jpa_app.controller;

import com.tss.__jpa_app.dto.*;
import com.tss.__jpa_app.service.StudentServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<StudentResponseDto> addStudent(@Valid @RequestBody StudentRequestDto student){
        return new ResponseEntity<>(studentService.addStudent(student),HttpStatus.CREATED);
    }

    @DeleteMapping("/Students/{age}")
    public ResponseEntity<String> deleteStudents(@PathVariable Integer age){
        int row=studentService.deleteByAge(age);
        return new ResponseEntity<>(row+" student records deleted",HttpStatus.OK);
    }

    @GetMapping("Students/address/{studentId}")
    public ResponseEntity<AddressResponseDto> getAddressByStudentId(@PathVariable Long studentId){
        return new ResponseEntity<>(
                studentService.getAddressByStudentId(studentId),
                HttpStatus.OK
        );
    }

    @PostMapping("Students/{studentId}/address")
    public ResponseEntity<StudentResponseDto> addAddress(@PathVariable Long studentId,@RequestBody AddressRequestDto addRequestDto){
        return new ResponseEntity<>(
                studentService.addAddress(studentId,addRequestDto),
                HttpStatus.OK
        );
    }

    @PutMapping("Students/{studentId}/address")
    public ResponseEntity<StudentResponseDto> updateAddress(@PathVariable Long studentId,@Valid @RequestBody AddressRequestDto addRequestDto){
        return new ResponseEntity<>(
                studentService.editAddress(studentId,addRequestDto),
                HttpStatus.OK
        );
    }

    @PostMapping("student/{studentId}/course/{courseId}")
    public ResponseEntity<Void> assignCourse(@PathVariable Long studentId,@PathVariable Long courseId){

        studentService.assignCourse(studentId,courseId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/student/{studentId}/courses")
    public ResponseEntity<Void> assignStudents(@PathVariable Long studentId, @RequestBody AssignCoursesRequest studentsRequest){

        studentService.assignCourses(studentId,studentsRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/student/{studentId}/courses")
    public ResponseEntity<List<CourseResponseDto>> getCourseByStudentId(@PathVariable Long studentId){
        return new ResponseEntity<>(
                studentService.getCourseByStudentId(studentId),
                HttpStatus.OK
        );
    }

}
