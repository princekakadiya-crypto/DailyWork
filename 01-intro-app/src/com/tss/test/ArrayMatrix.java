package com.tss.test;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayMatrix {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Boolean exit=false;
        int matrix1[][]=ReadMatrix();
        int matrix2[][]=ReadMatrix();

        do {
            System.out.println("1. Read Matrix");
            System.out.println("2. Print Matrix");
            System.out.println("3. Addition of Matrix");
            System.out.println("4. Multiplication of Matrix");
            System.out.println("5. Exit");
            System.out.println("Enter Your Choice : ");
            int choice= scanner.nextInt();

            switch (choice)
            {
                case 1:

                    matrix1=ReadMatrix();
                    matrix2=ReadMatrix();
                    break;
                case 2:
                    PrintMatrix(matrix1);
                    PrintMatrix(matrix2);
                    break;
                case 3:
                    AdditionOfMatrix(matrix1,matrix2);
                    break;
                case 4:
                    MultiplicationOfMatrix(matrix1,matrix2);
                    break;
                case 5:
                    exit=true;
                    break;
                    default:
                        System.out.println("Invalid Input.");
                        break;

            }
        }while (!exit);
    }
    private static int[][] ReadMatrix()
    {
        Scanner scanner=new Scanner(System.in);
        int rows,columns;
        do {
            System.out.println("Enter Number Of Rows for Matrix : ");
            try {
                rows = scanner.nextInt();
            }catch (InputMismatchException e)
            {
                System.out.println("Invalid Input Enter Number.");
                continue;
            }
            if (rows>0)
                break;
            else
                System.out.println("Row size must be greater then 0");
        }while (true);
        do {
            System.out.println("Enter Number Of Columns for Matrix : ");
            columns = scanner.nextInt();
            if (columns>0)
                break;
            else
                System.out.println("Columns size must be greater then 0");
        }while (true);

        int[][] matrix=new int[rows][columns];
        for(int i=0;i< rows;i++)
        {
            for (int j=0;j<columns;j++)
            {
                System.out.println("Enter value for index ("+i+","+j+") : ");
                matrix[i][j]=scanner.nextInt();
            }
        }
        return matrix;
    }
    private static void PrintMatrix(int[][] matrix)
    {
        System.out.println("Matrix : ");
        for(int i=0;i< matrix.length;i++)
        {
            for (int j=0;j< matrix[i].length;j++)
            {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    private static void AdditionOfMatrix(int[][] matrix1,int[][] matrix2)
    {
        if(matrix1.length== matrix2.length && matrix1[0].length==matrix2[0].length) {
            System.out.print("Addition of Matrix Row wise :\n");
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[i].length; j++) {
                    System.out.print((matrix1[i][j] + matrix2[i][j]) + " ");
                }
                System.out.println();

            }
            System.out.println();
        }
        else
        {
            System.out.println("Two matrix add only if they have same dimension");
        }

    }
    private static void MultiplicationOfMatrix(int[][] matrix1,int[][] matrix2)
    {
        if(matrix1[0].length==matrix2.length) {
            System.out.println("Multiplication of Matrix Row wise : \n");
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix2[0].length; j++) {
                    int sum = 0;
                    for (int k = 0; k < matrix1[0].length; k++) {
                        sum += matrix1[i][k] * matrix2[k][j];
                    }
                    System.out.print(sum + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        else {
            System.out.println("Number of column of first matrix must be equal to Number of row of second matrix");
        }
    }
}