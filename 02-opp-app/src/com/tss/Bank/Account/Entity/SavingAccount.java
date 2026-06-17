package com.tss.Bank.Account.Entity;

import com.tss.Bank.Exception.MinimumBalanceException;

public class SavingAccount extends Account {
    private double minimumBalance;

    public SavingAccount(String name, double balance, String accountType, double minimumBalance) {
        super(name, balance, accountType);
        this.minimumBalance = minimumBalance;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }
    public boolean withdraw(double amount)
    {
        if((getBalance()-amount)<minimumBalance)
        {
            throw new MinimumBalanceException(amount,minimumBalance);
        }
        else
        {
            setBalance(getBalance()-amount);
            return true;
        }
    }
    public void printDetail()
    {
        System.out.println("ID : "+getID());
        System.out.println("Name : "+getName());
        System.out.println("Balance : "+getBalance());
        System.out.println("Account Number : "+getAccountNumber());
        System.out.println("Account Type : "+getAccountType());
        System.out.println("Minimum Balance : "+minimumBalance);
        System.out.println();
    }
}
