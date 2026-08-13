package com.tss.__jpa_app.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CourseNotFoundException extends RuntimeException{
    private Long id;
    @Override
    public String getMessage() {
        return "course not found "+id;
    }
}
