package com.tss.test;

import com.tss.Comparator.BalanceComparator;
import com.tss.Comparator.NameComparator;
import com.tss.Validation.InputValidation;
import com.tss.model.Account;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccountTest {
    static List<Account> accounts=new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("1. Add");
            System.out.println("2. display Detail");
            System.out.println("3. deposit");
            System.out.println("4. withdraw");
            System.out.println("5. Transfer");
            System.out.println("6. display with sort id");
            System.out.println("7. display accounts with sort by balance");
            System.out.println("8. display accounts with sort by name");
            System.out.println("9. Exit");

            choice= InputValidation.readInt("Enter choice");

            switch (choice)
            {
                case 1:
                    addAccount();
                    break;
                case 2:
                    displayAccount();
                    break;
                case 3:
                    diposit();
                    break;
                case 4:
                    withdraw();
                    break;
                case 5:
                    transfer();
                    break;
                case 6:
                    Collections.sort(accounts);
                    displayAll();
                    break;
                case 7:
                    displayAllSortByBalance();
                    break;
                case 8:
                    displayAllSortByName();
                    break;
                case 9:
                    System.out.println("Exited.");
                    break;
                default:
                    System.out.println("Invalid choice");

            }
        }while (choice!=9);
    }

    private static void displayAllSortByName() {
        Collections.sort(accounts,new NameComparator());
        displayAll();
    }

    private static void displayAllSortByBalance() {
        Collections.sort(accounts,new BalanceComparator());
        displayAll();
    }

    private static void displayAll() {
        for (Account account:accounts)
        {
            System.out.println(account);
        }
    }

    private static void addAccount()
    {
        String name=InputValidation.readName("Enter Name : ");
        double balance=InputValidation.readDouble("Enter Balance : ",500,"Minimum 500 balance required");
        Account account=new Account(name,balance);
        accounts.add(account);
        System.out.println("Account add with Account Number : "+account.getAccountNumber());
    }
    private static void displayAccount()
    {
        int accountNumber=InputValidation.readInt("Enter Account Number :" );
        for (Account account:accounts)
        {
            if (account.getAccountNumber()==accountNumber)
            {
                System.out.println(account);
                return;
            }
        }
        System.out.println("Account Not found");
    }
    private static void diposit()
    {
        int accountNumber=InputValidation.readInt("Enter Account Number :" );
        for (Account account:accounts)
        {
            if (account.getAccountNumber()==accountNumber)
            {
                double amount=InputValidation.readDouble("Enter amount : ",0,"Amount should not be negative");
                account.deposit(amount);
                return;
            }
        }
        System.out.println("Account Not found");

    }

    private static void withdraw()
    {
        int accountNumberFrom=InputValidation.readInt("Enter Account Number :" );
        for (Account account:accounts)
        {
            if (account.getAccountNumber()==accountNumberFrom)
            {
                double amount=InputValidation.readDouble("Enter amount : ",0,"Amount should not be negative");
                account.withdraw(amount);
                return;
            }
        }
        System.out.println("Account not found");
    }
    private static void transfer()
    {
        Account accountFrom=null;
        int accountNumberFrom=InputValidation.readInt("Enter Account Number from :" );
        boolean found=false;
        for (Account account:accounts)
        {
            if (account.getAccountNumber()==accountNumberFrom)
            {
                accountFrom=account;
                break;
            }
        }
        if (accountFrom==null)
        {
            System.out.println("Account not found");
            return;
        }
        Account accountTo=null;
        int accountNumberTo=InputValidation.readInt("Enter Account Number from :" );
        for (Account account:accounts)
        {
            if (account.getAccountNumber()==accountNumberTo)
            {
                accountTo=account;
                break;
            }
        }
        if (accountTo==null)
        {
            System.out.println("Account not found");
            return;
        }
        double amount=InputValidation.readDouble("Enter amount : ",0,"Amount should not be negative");
        accountFrom.withdraw(amount);
        accountTo.withdraw(amount);
    }
}
