package com.tss.__jpa_app.controller;

import com.tss.__jpa_app.dto.*;
import com.tss.__jpa_app.service.CourseService;
import com.tss.__jpa_app.service.InstructorService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/app")
public class InstructorController {
    private final InstructorService instructorService;

    @GetMapping("/instructors")
    public ResponseEntity<PageDto<InstructorResponseDto>> getInstructor(@RequestParam(defaultValue = "0") int page,
                                                                   @RequestParam(defaultValue = "2") int size){

        return new ResponseEntity<>(
                instructorService.getAllInstructor(page, size),
                HttpStatus.OK
        );
    }

    @PostMapping("/instructors")
    public ResponseEntity<InstructorResponseDto> addInstructor(@RequestBody InstructorRequestDto instructorRequestDto){
        return new ResponseEntity(
                instructorService.addInstructor(instructorRequestDto),
                HttpStatus.CREATED
        );
    }

    @PostMapping("/instructor/{instructorId}/course/{courseId}")
    public ResponseEntity<Void> assignCourse(@PathVariable Long instructorId,@PathVariable Long courseId){
        instructorService.assignCourse(instructorId,courseId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/instructor/{instructorId}/courses")
    public ResponseEntity<List<CourseResponseDto>> getCourseByInstructorId(@PathVariable Long instructorId){
        return new ResponseEntity<>(
                instructorService.getCourseByInstructorId(instructorId),
                HttpStatus.OK
        );
    }

    @GetMapping("/instructor/{instructorId}/courses/count")
    public ResponseEntity<Long> getCourseCountByInstructor(
            @PathVariable Long instructorId) {

        return ResponseEntity.ok(
                instructorService.getCourseCountByInstructor(instructorId)
        );
    }

    @GetMapping("/instructor/courses/count")
    public ResponseEntity<List<CoursesCountDto>> getCourseCount() {

        return ResponseEntity.ok(
                instructorService.getCoursesCount()
        );
    }
}
