package com.tss.test;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Number1:");
        int num1=sc.nextInt();

        System.out.println("Enter Number2:");
        int num2=sc.nextInt();

        int sum= addition(num1,num2);
        int sub= subtraction(num1,num2);
        int mul= multiplication(num1,num2);
        float div= division(num1,num2);

        System.out.println("Addition : "+sum);
        System.out.println("subtraction : "+sub);
        System.out.println("multiplication : "+mul);
        System.out.println("division : "+div);
    }
    private static int addition(int num1,int num2)
    {
        return num1+num2;
    }

    private static int subtraction(int num1,int num2)
    {
        return num1-num2;
    }

    private static int multiplication(int num1,int num2)
    {
        return num1*num2;
    }

    private static float division(int num1,int num2)
    {
        return num1/num2;

    }

}
