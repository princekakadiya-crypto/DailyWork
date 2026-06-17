package com.tss.test;

import com.tss.model.IFactorial;

public class IFactorialTest {
    public static void main(String[] args) {
        IFactorial factorial=(number) ->{
            int result=1;
           for (int i=2;i<=number;i++)
           {
               result*=i;
           }
           return result;
        } ;

        System.out.println(factorial.factorial(5));
    }
}
