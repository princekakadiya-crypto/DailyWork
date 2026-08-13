package com.tss.__jpa_app.exception;

public class InvalidOtpException extends RuntimeException{
    public InvalidOtpException(String message) {
        super(message);
    }
}
