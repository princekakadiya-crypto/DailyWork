package com.tss.test;

import java.util.Scanner;

public class SortIntegerArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        do {
            System.out.println("Enter Number Of Elements : ");
            size = scanner.nextInt();
            if (size > 0)
                break;
            else
                System.out.println("Size must be greater then 0");
        } while (true);
        int[] arrayElements = new int[size];
        scanner.nextLine();
        for (int i = 0; i < size; i++) {
            System.out.println("Enter Element " + (i + 1) + " : ");
            arrayElements[i] = scanner.nextInt();
        }
        for (int i=0;i<arrayElements.length-1;i++)
        {
            for (int j=i+1;j<arrayElements.length;j++)
            {
                if(arrayElements[i]>arrayElements[j])
                {
                    int temp=arrayElements[i];
                    arrayElements[i]=arrayElements[j];
                    arrayElements[j]=temp;
                }
            }
        }
        System.out.println("Array Elements After Sort");
        for (int i=0;i<size;i++)
        {
            System.out.println("Element "+(i+1)+" : "+arrayElements[i]);
        }
    }
}
