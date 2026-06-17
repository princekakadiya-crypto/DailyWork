package com.tss.Bank.Exception;

public class NegativeAmountException extends RuntimeException {
    private double amount;

    public NegativeAmountException(double amount) {
        this.amount = amount;
    }
    public String getMessage()
    {
        return "Can not insert negative amount. you entered :"+amount;
    }
}
