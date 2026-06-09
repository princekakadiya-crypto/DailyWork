package com.tss.test;

import java.util.Scanner;

public class FindMaximumFromArray {
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
        int max=arrayElements[0];
        for (int i=1;i< arrayElements.length;i++)
        {
            if(max<arrayElements[i])
                max=arrayElements[i];
        }
        System.out.println("Max Element is "+max);
    }
}
