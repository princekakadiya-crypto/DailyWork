package com.tss.behavioural.Strategy.model;

import jdk.dynalink.Operation;

public class OperationStrategy {
    IOperation operation;

    public OperationStrategy(IOperation operation) {
        this.operation = operation;
    }

    public void doOperation(int a,int b)
    {
        System.out.println(operation.doOperation(a,b));
    }
}
