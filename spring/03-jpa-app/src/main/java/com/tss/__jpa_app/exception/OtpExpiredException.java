package com.tss.__jpa_app.exception;

public class OtpExpiredException extends RuntimeException{
    public OtpExpiredException(String message) {
        super(message);
    }
}
