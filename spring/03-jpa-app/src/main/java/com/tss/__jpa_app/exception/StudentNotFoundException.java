package com.tss.__jpa_app.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
public class StudentNotFoundException extends RuntimeException{
    private Long id;
    @Override
    public String getMessage() {
        return "Student Not Found "+id;
    }
}
