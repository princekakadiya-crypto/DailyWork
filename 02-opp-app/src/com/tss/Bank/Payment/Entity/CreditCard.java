package com.tss.Bank.Payment.Entity;

public class CreditCard extends Payment {

    private String creditCardNumber;
    private String holderName;

    public CreditCard(double amount, String creditCardNumber, String holderName) {
        super( amount);
        this.creditCardNumber = creditCardNumber;
        this.holderName = holderName;
    }

    @Override
    public boolean transfer() {
        return false;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }
}
