package com.tss;

public class Student {
    StudentService studentService;

    public Student(StudentService studentService) {
        this.studentService = studentService;
    }

    float calculatePercent()
    {
        return studentService.getMarks()/ studentService.getSubjects();
    }
}
