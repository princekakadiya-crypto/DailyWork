package com.tss.model;

import java.util.Random;

public class Account implements Comparable<Account> {
    private static int isCount=1;
    private int id;
    private int accountNumber;
    private String name;
    private double balance;

    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.id=isCount++;
        this.accountNumber=generateAccountNumber();
    }

    private int generateAccountNumber()
    {
        Random random = new Random();

        int eighthDigitNumber = random.nextInt(90000000) + 10000000;
        return eighthDigitNumber;
    }

    public int getId() {
        return id;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount)
    {
        balance+= amount;
    }

    public void withdraw(double amount)
    {
        if ((balance-amount)<500)
        {
            System.out.println("Minimum 500 balance required.");
            return;
        }
        balance-=amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNumber=" + accountNumber +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }


    @Override
    public int compareTo(Account o) {
        return this.id-o.getId();
    }
}
