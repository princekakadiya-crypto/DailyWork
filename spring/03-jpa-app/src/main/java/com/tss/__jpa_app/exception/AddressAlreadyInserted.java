package com.tss.__jpa_app.exception;

public class AddressAlreadyInserted extends RuntimeException {
    @Override
    public String getMessage() {
        return "Address is already inserted..";
    }
}
