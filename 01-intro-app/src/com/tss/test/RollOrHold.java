package com.tss.test;

import java.util.Random;
import java.util.Scanner;

public class RollOrHold {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Random random=new Random();
        int totalScore=0;
        int totalTurn=0;
        do {
            totalTurn++;
            System.out.println("\nTURN "+totalTurn);
            int turnScore=0;
            do {
                char input;
                do {
                    System.out.println("Current Turn Total : "+turnScore);
                    System.out.println("Roll or Hold? (r/h):");
                    input=scanner.next().charAt(0);
                    if (input=='r' || input=='h')
                        break;
                    else
                        System.out.println("Invalide input.");
                }while (true);

                if (input=='r') {
                    int die = random.nextInt(6) + 1;
                    System.out.println("Die: "+die);
                    if (die == 1) {
                        turnScore = 0;
                        System.out.println("Turn over.No score.");
                        if (totalScore>0)
                            System.out.println("Total Score : "+totalScore);
                        break;
                    }
                    turnScore+=die;
                } else if (input=='h') {
                    totalScore+=turnScore;
                    System.out.println("Score for turn: "+turnScore);
                    System.out.println("Total Score : "+totalScore);
                    break;
                }
            }while(true);
        }while (totalScore<20);
        System.out.println("\nYou finished in "+totalTurn+" turns!");
        System.out.println("\nGame over");
    }
}
