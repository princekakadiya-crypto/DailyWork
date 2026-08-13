package com.tss.__jpa_app.controller;

import com.tss.__jpa_app.dto.*;
import com.tss.__jpa_app.service.CourseService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/app")
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/coursess")
    public ResponseEntity<PageDto<CourseResponseDto>> getCourse(@RequestParam(defaultValue = "0") int page,
                                                                        @RequestParam(defaultValue = "2") int size){

        return new ResponseEntity<>(
                courseService.getAllCourse(page, size),
                HttpStatus.OK
        );
    }

    @PostMapping("/course")
    public ResponseEntity<CourseResponseDto> addCourse(@RequestBody CourseRequestDto courseRequestDto){
        return new ResponseEntity(
                courseService.addCourse(courseRequestDto),
                HttpStatus.OK
        );
    }

    @PostMapping("/course/{courseId}/instructor/{instructorId}")
    public ResponseEntity<Void> assignCourse(@PathVariable Long courseId,@PathVariable Long instructorId){
        courseService.assignCourse(courseId,instructorId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/course/{courseId}/instructor")
    public ResponseEntity<InstructorResponseDto> getInstructorByCourseId(@PathVariable Long courseId){
        return new ResponseEntity<>(
                courseService.getInstructorByCourseId(courseId),
                HttpStatus.OK
        );
    }

    @PostMapping("/course/{courseId}/students")
    public ResponseEntity<Void> assignStudents(@PathVariable Long courseId, @RequestBody AssignStudentsRequest studentsRequest){

        courseService.assignStudents(courseId,studentsRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/course/{courseId}/students")
    public ResponseEntity<List<StudentResponseDto>> getStudentByCourseId(@PathVariable Long courseId){
        return new ResponseEntity<>(
                courseService.getStudentByCourseId(courseId),
                HttpStatus.OK
        );
    }
}
