package com.tss.test;

import com.tss.model.IFindMaximum;

public class IFindMaximumTEst {
    public static void main(String[] args) {
        IFindMaximum findMaximum= (number1, number2) -> {
            if (number1>number2)
                return number1;
            return number2;
        };

        System.out.println(findMaximum.Max(10,20));
        System.out.println(findMaximum.Max(30,20));
        System.out.println(findMaximum.Max(10,50));
    }
}
