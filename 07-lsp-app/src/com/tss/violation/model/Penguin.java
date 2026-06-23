package com.tss.violation.model;

public class Penguin extends Bird{
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguin can not fly");
    }
}
