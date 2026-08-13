package com.tss.__jpa_app.exception;

import com.tss.__jpa_app.error.ErrorResponseDto;
import com.tss.__jpa_app.error.ErrorValidationResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log= LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> studentNotFoundException(StudentNotFoundException studentNotFoundException, HttpServletRequest request){
        ErrorResponseDto error=new ErrorResponseDto(
                HttpStatus.NOT_FOUND.value(),
                studentNotFoundException.getMessage(),
                LocalDateTime.now(),
                request.getRequestURI()
        );

        return new ResponseEntity<>(
                error,
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(OtpAlreadyUsedException.class)
    public ResponseEntity<ErrorResponseDto> otpAlreadyUsedException(OtpAlreadyUsedException otpAlreadyUsedException, HttpServletRequest request){


        ErrorResponseDto error=new ErrorResponseDto(
                HttpStatus.CONFLICT.value(),
                otpAlreadyUsedException.getMessage(),
                LocalDateTime.now(),
                request.getRequestURI()
        );

        return new ResponseEntity<>(
                error,
                HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(OtpExpiredException.class)
    public ResponseEntity<ErrorResponseDto> otpExpiredException(OtpExpiredException otpExpiredException, HttpServletRequest request){

        ErrorResponseDto error=new ErrorResponseDto(
                HttpStatus.BAD_REQUEST.value(),
                otpExpiredException.getMessage(),
                LocalDateTime.now(),
                request.getRequestURI()
        );

        return new ResponseEntity<>(
                error,
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(InvalidOtpException.class)
    public ResponseEntity<ErrorResponseDto> invalidOtpException(InvalidOtpException invalidOtpException, HttpServletRequest request){


        ErrorResponseDto error=new ErrorResponseDto(
                HttpStatus.BAD_REQUEST.value(),
                invalidOtpException.getMessage(),
                LocalDateTime.now(),
                request.getRequestURI()
        );

        return new ResponseEntity<>(
                error,
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(AddressNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> addressNotFoundException(AddressNotFoundException addressNotFoundException, HttpServletRequest request){
        ErrorResponseDto error=new ErrorResponseDto(
                HttpStatus.NOT_FOUND.value(),
                addressNotFoundException.getMessage(),
                LocalDateTime.now(),
                request.getRequestURI()
        );

        return new ResponseEntity<>(
                error,
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(AddressAlreadyInserted.class)
    public ResponseEntity<ErrorResponseDto> addressNotFoundException(AddressAlreadyInserted addressAlreadyInserted, HttpServletRequest request){
        ErrorResponseDto error=new ErrorResponseDto(
                HttpStatus.CONFLICT.value(),
                addressAlreadyInserted.getMessage(),
                LocalDateTime.now(),
                request.getRequestURI()
        );

        return new ResponseEntity<>(
                error,
                HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(InstructorNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> instructorNotFoundException(InstructorNotFoundException instructorNotFoundException, HttpServletRequest request){
        ErrorResponseDto error=new ErrorResponseDto(
                HttpStatus.NOT_FOUND.value(),
                instructorNotFoundException.getMessage(),
                LocalDateTime.now(),
                request.getRequestURI()
        );

        return new ResponseEntity<>(
                error,
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> courseNotFoundException(CourseNotFoundException courseNotFoundException, HttpServletRequest request){

        log.warn("Course not found");
        ErrorResponseDto error=new ErrorResponseDto(
                HttpStatus.NOT_FOUND.value(),
                courseNotFoundException.getMessage(),
                LocalDateTime.now(),
                request.getRequestURI()
        );

        return new ResponseEntity<>(
                error,
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDto> notFoundException(NotFoundException notFoundException, HttpServletRequest request){
        ErrorResponseDto error=new ErrorResponseDto(
                HttpStatus.NOT_FOUND.value(),
                notFoundException.getMessage(),
                LocalDateTime.now(),
                request.getRequestURI()
        );

        return new ResponseEntity<>(
                error,
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorValidationResponse> handleValidationException(MethodArgumentNotValidException exception){

        Map<String, String> errors = new HashMap<>();

        exception.getBindingResult().getFieldErrors().forEach(error -> {
                    errors.put(error.getField(), error.getDefaultMessage());
        });

        ErrorValidationResponse response=new ErrorValidationResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Validation Failed",
                LocalDateTime.now(),
                errors
        );

        return  new ResponseEntity<>(
                response,
                HttpStatus.BAD_REQUEST
        );
    }
}
