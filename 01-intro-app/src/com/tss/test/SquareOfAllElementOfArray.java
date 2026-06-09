package com.tss.test;

import java.util.Scanner;
import com.tss.validation.InputValidation;

public class SquareOfAllElementOfArray {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int size;
        do {
            size = InputValidation.ReadInt(scanner,"Enter Number Of Elements : ");
            if (size>0)
                break;
            else
                System.out.println("Size must be greater then 0");
        }while (true);
        int[] array=new int[size];
        for (int i=0;i<size;i++)
        {
            array[i]=InputValidation.ReadInt(scanner,"Enter Element "+(i+1)+" : ");
            if (i>0 && array[i]<array[i-1])
            {
                System.out.println("Element must ge greater then previous.");
                i--;
            }
        }
        System.out.println("squares of all elements");
        int[] squareOfElement=SquareOfArrayElements(array);
        for (int i=0;i<squareOfElement.length;i++)
        {
            System.out.println("Element "+(i+1)+" : "+squareOfElement[i]);
        }
    }
    private static int[] SquareOfArrayElements(int[] array)
    {
        int[] arraySquare=new int[array.length];
        int left=0;
        int right=array.length-1;
        int position=array.length-1;

        while (left<=right)
        {
            int squareLeft=array[left]*array[left];
            int squareRight=array[right]*array[right];

            if(squareLeft>squareRight)
            {
                arraySquare[position]=squareLeft;
                left++;
            }
            else
            {
                arraySquare[position]=squareRight;
                right--;
            }
            position--;
        }
        return  arraySquare;
    }
}
