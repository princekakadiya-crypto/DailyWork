package com.tss.Exception;

public class AgeInvalidException extends RuntimeException {
    private int age;

    public AgeInvalidException(int age) {
        this.age = age;
    }
    public String getMessage()
    {
        return "Invalid age. you entered :"+age;
    }
}
