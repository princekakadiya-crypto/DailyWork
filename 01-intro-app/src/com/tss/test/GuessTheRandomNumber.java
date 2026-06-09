package com.tss.test;

import java.util.Random;
import java.util.Scanner;

public class GuessTheRandomNumber {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Random random=new Random();
        int playAgain;
        do {
            int random_Number = random.nextInt(100) + 1;

            int guess;
            int attempt = 0;
            do {
                System.out.println("Guess the number Between 1 to 100 : ");
                guess = scanner.nextInt();
                if(guess>100 || guess<1)
                {
                    System.out.println("Invalid Input");
                }
                attempt++;
                if (guess == random_Number) {
                    System.out.println("correct Guess");
                    System.out.println("Total tries to solve the game : " + attempt);
                    break;
                } else if (guess < random_Number) {
                    System.out.println("Sorry, Too Low");
                } else
                    System.out.println("Sorry,Too High");
            } while (attempt < 5);
            if (attempt==5)
                System.out.println("Game over...  number is "+random_Number);

            do {
                System.out.println("for Play again enter 1. for Exit enter 0");
                playAgain = scanner.nextInt();
                if (playAgain == 0)
                {
                    System.out.println("Exited..");
                    break;
                } else if (playAgain==1) {
                    break;
                }
                else
                {
                    System.out.println("Invalid Input");
                }
            }while (true);
        }while (playAgain==1);
    }
}
