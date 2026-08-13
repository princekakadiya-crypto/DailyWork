package com.tss.__jpa_app.exception;

public class OtpAlreadyUsedException extends RuntimeException{
    public OtpAlreadyUsedException(String message) {
        super(message);
    }
}
