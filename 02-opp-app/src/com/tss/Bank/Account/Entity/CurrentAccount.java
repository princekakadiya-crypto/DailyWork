package com.tss.Bank.Account.Entity;

public class CurrentAccount extends Account {
    private double overdraft;

    public CurrentAccount(String name, double balance, String accountType, double overdraft) {
        super(name, balance, accountType);
        this.overdraft = overdraft;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    public boolean withdraw(double amount)
    {
        if((getBalance()-amount+overdraft)<0)
        {
            System.out.println("Insufficient Balance");
            return false;
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
        System.out.println("OverDraft Limit : "+overdraft);
        //System.out.println("OverDraft Amount : "+(overdraft+getBalance()<overdraft?Math.abs(getBalance()):"0"));
        System.out.println();
    }
}
