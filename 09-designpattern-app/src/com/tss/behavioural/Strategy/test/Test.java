package com.tss.behavioural.Strategy.test;

import com.tss.behavioural.Strategy.model.AddOperation;
import com.tss.behavioural.Strategy.model.IOperation;
import com.tss.behavioural.Strategy.model.MultiplicationOperation;
import com.tss.behavioural.Strategy.model.OperationStrategy;

public class Test {
    public static void main(String[] args) {
        OperationStrategy operationStrategy=new OperationStrategy(new AddOperation());
        operationStrategy.doOperation(10,20);

        OperationStrategy operationStrategy1=new OperationStrategy(new MultiplicationOperation());
        operationStrategy1.doOperation(10,20);
    }
}
