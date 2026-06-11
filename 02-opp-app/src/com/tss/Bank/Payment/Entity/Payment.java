package com.tss.Bank.Payment.Entity;

import java.time.LocalDateTime;

public abstract class Payment {
    private static int transactionCount=1234;
    private int transactionId;
    private double amount;
    private String status;
    private String transactionDate;
    LocalDateTime dateTime=LocalDateTime.now();

    public Payment(double amount) {
        this.transactionId = transactionCount++;
        this.amount = amount;
        status="Done";
        transactionDate=dateTime.toString();

    }

    public abstract boolean transfer();

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }
}
