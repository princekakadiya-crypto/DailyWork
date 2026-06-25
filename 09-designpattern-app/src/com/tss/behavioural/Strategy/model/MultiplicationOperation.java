package com.tss.behavioural.Strategy.model;

public class MultiplicationOperation implements IOperation{
    @Override
    public int doOperation(int a, int b) {
        return a*b;
    }
}
