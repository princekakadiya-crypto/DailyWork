package com.tss.Bank.Account.Entity;

public interface Transaction {
    boolean withdraw(double amount);
    void printDetail();
    void deposit(double amount);
}
