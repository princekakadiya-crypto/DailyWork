package com.tss.test;

import com.tss.Entity.Account;

import java.util.Scanner;

public class testAccount {
    public static void main(String[] args) {
        Account account1=new Account();
        Scanner scanner=new Scanner(System.in);
        while (true)
        {
            System.out.println("Enter Account Holder name : ");
            try
            {
                account1.setName(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Invalid input");
                scanner.next();
            }
        }
        while (true)
        {
            System.out.println("Enter Amount : ");
            try
            {
                int amount= scanner.nextInt();
                if (amount>=500)
                {
                    account1.setBalance(amount);
                    break;
                }
                System.out.println("Minimum 500 mount Required");
            } catch (Exception e) {
                System.out.println("Invalid input");
                scanner.next();
            }
        }
        while (true)
        {
            System.out.println("1 for Saving Account ");
            System.out.println("2 for Current Account");
            System.out.println("Enter Account Type : ");
            try
            {
                int accountType= scanner.nextInt();
                if (accountType==1)
                {
                    account1.setAccountType("Saving Account");
                    break;
                } else if (accountType==2) {
                    account1.setAccountType("Current Account");
                    break;
                }
                System.out.println("Invalid choice");
            } catch (Exception e) {
                System.out.println("Invalid input");
                scanner.next();
            }
        }
        account1.deposit(1500);
        account1.withdraw(500);
        account1.withdraw(2000);
        account1.printDetail();
        System.out.println();
        Account account2=new Account("Prince",1500,"Saving Account");
        account2.printDetail();
    }
}
