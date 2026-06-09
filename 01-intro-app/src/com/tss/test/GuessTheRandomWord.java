package com.tss.test;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessTheRandomWord {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String randomWord=RandomWord();
        System.out.println(randomWord);
        char[] guessedWord=new char[randomWord.length()];
        Arrays.fill(guessedWord,' ');
        boolean allLetterGuessed=true;
        boolean resultOfTheGame;
        int availableLives=10;
        do {
            System.out.println("\nEnter letter to guess : ");
            char letter=scanner.next().charAt(0);
            boolean letterGuessed=false;

            for(int i=0;i<randomWord.length();i++)
            {
                if (guessedWord[i]==' ' && letter==randomWord.charAt(i))
                {
                    guessedWord[i]=randomWord.charAt(i);
                    letterGuessed=true;
                    allLetterGuessed = true;
                    System.out.print("guessed word : ");
                    for (char ch : guessedWord) {
                        System.out.print(ch);
                        if (ch == ' ')
                            allLetterGuessed = false;
                    }
                    break;
                }
            }
            if (!letterGuessed) {
                System.out.println("\nLetter is not in the word");
                availableLives--;
                System.out.println("Available lives : "+availableLives);
                if (availableLives==0) {
                    resultOfTheGame = false;
                    break;
                }
            }
            if (allLetterGuessed) {
                resultOfTheGame=true;
                break;
            }

        }while (true);
        System.out.println("\nGame Over");
        if (resultOfTheGame) {
            System.out.println("You Won The Game");
        }
        else
        {
            System.out.println("You Loss The Game");
        }
    }

    private static String RandomWord()
    {
        Random random =new Random();
        int length= random.nextInt(8)+3;
        String randomName="";
        for (int i=0;i<=length;i++)
        {
            randomName+=(char)('a'+random.nextInt(26));
        }
        return randomName;
    }
}
