package com.tss.__jpa_app.service;

import com.tss.__jpa_app.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InstructorServiceImplTest {

    @Mock
    CourseRepository courseRepository;

    @InjectMocks
    InstructorServiceImpl instructorService;

    @Test
    void canDeleteInstructor() {
        when(courseRepository.countCoursesByInstructorId(1L)).thenReturn(2L);

        instructorService.canDeleteInstructor(1L);

        verify(courseRepository).countCoursesByInstructorId(1L);
    }

    @Test
    void addInstructor() {

    }
}