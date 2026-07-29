package com.tss;

import java.sql.Date;
import java.util.Scanner;

public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readName(String message) {

        while (true) {

            System.out.print(message);
            String name = scanner.nextLine().trim();

            if (name.matches("[a-zA-Z ]{2,30}")) {
                return name;
            }

            System.out.println("Invalid name! Only letters allowed (2-30 chars).");
        }
    }
    public static int readInt(String message) {
        while (true) {
            System.out.print(message);
            try {
                int number = Integer.parseInt(scanner.nextLine().trim());
                if (number > 0) {
                    return number;
                }
                System.out.println("Please enter a positive number.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number! Try again.");
            }
        }
    }

    public static double readDouble(String message) {
        while (true) {
            System.out.print(message);
            try {
                double number = Double.parseDouble(scanner.nextLine().trim());
                if (number >= 0) {
                    return number;
                }
                System.out.println("Please enter a valid amount.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid decimal number!");
            }
        }
    }

    public static String readDescription(String message) {
        while (true) {
            System.out.print(message);
            String description = scanner.nextLine().trim();
            if (!description.isEmpty()) {
                return description;
            }
            System.out.println("Description cannot be empty.");
        }
    }

    public static Date readDate(String message) {
        while (true) {
            System.out.print(message);
            try {
                return Date.valueOf(scanner.nextLine().trim());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid date! Use yyyy-MM-dd");
            }
        }
    }

}
