package com.tss.test;

import com.tss.Entity.Player;

import java.util.Scanner;

public class testPlayer {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Player player1=new Player();
        while (true)
        {
            System.out.println("Enter ID : ");
            try
            {
                int id=0;
                id=scanner.nextInt();
                player1.setId(id);
                break;
            } catch (Exception e) {
                System.out.println("Invalid input");
                scanner.next();

            }
        }
        scanner.nextLine();
        while (true)
        {
            System.out.println("Enter player name : ");
            try
            {
                player1.setName(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Invalid input");
                scanner.next();
            }
        }
        while (true)
        {
            System.out.println("Enter Number Of Matchas : ");
            try
            {
                int numberOfMatchas= scanner.nextInt();
                if (numberOfMatchas>=0)
                {
                    player1.setNumberOfMatchas(numberOfMatchas);
                    break;
                }
                System.out.println("Number of matchas should not be negative");
            } catch (Exception e) {
                System.out.println("Invalid input");
                scanner.next();

            }
        }
        while (true)
        {
            System.out.println("Enter runs : ");
            try
            {
                int runs= scanner.nextInt();
                if (runs>=0)
                {
                    player1.setRuns(runs);
                    break;
                }
                System.out.println("Number of Runs should not be negative");
            } catch (Exception e) {
                System.out.println("Invalid input");
                scanner.next();

            }
        }
        while (true)
        {
            System.out.println("Enter Wicket : ");
            try
            {
                int wicket= scanner.nextInt();
                if (wicket>=0)
                {
                    player1.setWickets(wicket);
                    break;
                }
                System.out.println("Number of Wicket should not be negative");
            } catch (Exception e) {
                System.out.println("Invalid input");
                scanner.next();

            }
        }
        player1.printDetails();
    }
}
