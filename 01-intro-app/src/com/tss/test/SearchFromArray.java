package com.tss.test;

import java.util.Scanner;

public class SearchFromArray {
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
        String[] arrayElements=new String[size];
        scanner.nextLine();
        for(int i=0;i<size;i++)
        {
            System.out.println("Enter Element "+(i+1)+" : ");
            arrayElements[i]=scanner.nextLine();
        }
        System.out.println("Array Elements ");
        for (int i=0;i<size;i++)
        {
            System.out.println("Element "+(i+1)+" : "+arrayElements[i]);
        }
        System.out.println("Enter Element to Search : ");
        String searchElement=scanner.nextLine();
        boolean searchFound=false;
        for(int i=0;i<arrayElements.length;i++)
        {
            if (searchElement.equalsIgnoreCase(arrayElements[i]))
            {
                searchFound=true;
                System.out.println("Element found at index "+i);
                break;
            }
        }
        if (!searchFound)
        {
            System.out.println("Element Not Found.");
        }
    }
}
