package com.tss.test;

import java.util.Scanner;

public class RideCalculater {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter height : ");
        int height= scanner.nextInt();
        int charge;
        if (height>120)
        {

            System.out.println("Enter Age:");
            int age=scanner.nextInt();
            if(age<12)
                charge=5;
            else if (age<=18)
                charge=7;
            else if(age>=45 && age<=55)
                charge=0;
            else
                charge=12;
            scanner.nextLine();
            System.out.println("Enter 1 for if you want photo else enter 0 :");

            int photo=scanner.nextInt();
            do {
                if (photo==1)
                {
                    charge+=3;
                    break;
                }
                else if (photo==0) {
                    break;
                }
                else {
                    System.out.println("Invalid Input");
                    System.out.println("Re-Enter 1 for if you want photo else enter 0 :");
                    photo=scanner.nextInt();
                }

            }while (true);

            System.out.println("Total Bill : "+charge);
        }
        else
        {
            System.out.println("Can/'t ride");
        }
    }
}
