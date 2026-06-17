package com.tss.test;

import com.tss.model.ICheckPrime;

public class ICheckPrimeTest {
    public static void main(String[] args) {
        ICheckPrime iCheckPrime=(number) ->{
           for (int i=2;i<number/2;i++)
           {
               if (number%i==0)
                   return false;
           }
           return true;
        } ;

        System.out.println(iCheckPrime.checkPrime(7));
    }
}
