package com.tss.behavioural.observer.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Account {
    private String accountNumber;
    private String name;
    private double balance;
    private String mobileNumber;
    private String Email;
    private List<INotify> notifies=new ArrayList<>();

    public Account(String name, double balance, String mobileNumber, String email) {
        this.name = name;
        this.balance = balance;
        this.mobileNumber = mobileNumber;
        Email = email;
        accountNumber=generateAccountNumber();
    }

    public void addNotifies(INotify notifie) {
        notifies.add(notifie);
    }

    public List<INotify> getNotifies() {
        return notifies;
    }

    private String generateAccountNumber()
    {
        Random random = new Random();

        int eighthDigitNumber = random.nextInt(90000000) + 10000000;
        return Integer.toString(eighthDigitNumber);
    }

    public void deposite(double amount)
    {
        balance+=amount;
    }

    public boolean withdraw(double amount)
    {
        if (balance-amount<500)
        {
            System.out.println("minimum 500 balance requierd");
            return false;
        }
        balance-=amount;
        return true;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return Email;
    }
}
