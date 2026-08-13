package com.tss.__jpa_app.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InstructorNotFoundException extends RuntimeException{
    private Long id;
    @Override
    public String getMessage() {
        return "Instructor not found "+id;
    }
}
