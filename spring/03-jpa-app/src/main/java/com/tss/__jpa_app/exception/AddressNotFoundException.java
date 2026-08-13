package com.tss.__jpa_app.exception;

import lombok.AllArgsConstructor;

public class AddressNotFoundException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Address Not Found ";
    }
}
