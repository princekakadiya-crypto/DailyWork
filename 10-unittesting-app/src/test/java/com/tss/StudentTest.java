package com.tss;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;


class StudentTest {

    Student student;
    @Mock
    StudentService studentService;
    @BeforeEach
    void init()
    {
        MockitoAnnotations.openMocks(this);
        student=new Student(studentService);
    }
    @Test
    void calculatePercentTest() {

        Mockito.when(studentService.getMarks()).thenReturn(900);
        Mockito.when(studentService.getSubjects()).thenReturn(10);
        assertEquals(91.0,student.calculatePercent());
    }
}