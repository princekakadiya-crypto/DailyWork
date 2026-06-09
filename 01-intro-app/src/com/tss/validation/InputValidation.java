package com.tss.validation;

import java.util.Scanner;

public class InputValidation {
    public static int ReadInt(Scanner scanner,String message)
    {
        int number;
        while (true){
            System.out.println(message);
            try {
                number= scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input");
                scanner.next();
            }
        }
        return number;
    }
}
