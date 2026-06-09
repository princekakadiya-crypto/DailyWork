package com.tss.test;

import java.util.Scanner;

public class SumOfAllElement {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int size;
        do {
            System.out.println("Enter Number Of Elements : ");
            size = scanner.nextInt();
            if (size>0)
                break;
            else
                System.out.println("Size must be greater then 0");
        }while (true);
        int[] arrayElements=new int[size];
        scanner.nextLine();
        for(int i=0;i<size;i++)
        {
            System.out.println("Enter Element "+(i+1)+" : ");
            arrayElements[i]=scanner.nextInt();
        }
        int sum=0;
        for (int i=0;i<size;i++)
        {
            sum+=arrayElements[i];
        }
        System.out.println("SUm of All Element : "+sum);
    }
}
