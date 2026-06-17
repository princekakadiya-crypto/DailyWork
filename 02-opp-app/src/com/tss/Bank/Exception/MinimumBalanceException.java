package com.tss.Bank.Exception;

public class MinimumBalanceException extends RuntimeException{
    private double amount;
    private double minimumBalance;
    public MinimumBalanceException(double amount,double minimumBalance) {
        this.amount = amount;
        this.minimumBalance=minimumBalance;
    }

    public String getMessage()
    {
        return "Minimum balance "+minimumBalance+" required. you entered : "+amount;
    }
}
