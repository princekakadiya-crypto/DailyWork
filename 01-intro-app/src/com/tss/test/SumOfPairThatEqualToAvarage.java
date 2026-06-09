package com.tss.test;

import com.tss.validation.InputValidation;

import java.util.Scanner;

public class SumOfPairThatEqualToAvarage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        do {
            size = InputValidation.ReadInt(scanner, "Enter Number Of Elements : ");
            if (size > 0)
                break;
            else
                System.out.println("Size must be greater then 0");
        } while (true);
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = InputValidation.ReadInt(scanner, "Enter Element " + (i + 1) + " : ");
        }
        boolean find=ChackSumOfPairThatEqualToAvarage(array);
        if (find)
            System.out.println("Pair exists");
        else
            System.out.println("Pair Not exists");
    }
    private static boolean ChackSumOfPairThatEqualToAvarage(int[] array)
    {
        int sum=0;
        for(int number : array)
        {
            sum+=number;
        }
        for (int i=0;i<array.length;i++)
        {
            for (int j=i+1;j<array.length;j++)
            {
                if ((array[i]+array[j])*array.length==sum)
                    return true;
            }
        }
        return false;
    }
}
