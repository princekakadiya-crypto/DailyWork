package com.tss.Bank.Payment.Entity;


public class UPI extends Payment {
    private String upiID;

    public UPI(double amount, String upiID) {
        super(amount);
        this.upiID = upiID;
    }

    @Override
    public boolean transfer() {
        return false;
    }

    public String getUpiID() {
        return upiID;
    }

    public void setUpiID(String upiID) {
        this.upiID = upiID;
    }

}
