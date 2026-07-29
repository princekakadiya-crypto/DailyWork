package com.tss.__jpa_app.exception;

import com.tss.__jpa_app.error.ErrorResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> studentNotFoundException(StudentNotFoundException studentNotFoundException, HttpServletRequest request){
        ErrorResponseDto error=new ErrorResponseDto(HttpStatus.NOT_FOUND.value(),studentNotFoundException.getMessage(), LocalDateTime.now(),request.getRequestURI());

        return new ResponseEntity<>(
                error,
                HttpStatus.NOT_FOUND
        );
    }
}
