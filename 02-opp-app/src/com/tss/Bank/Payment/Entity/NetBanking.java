package com.tss.Bank.Payment.Entity;

public class NetBanking extends Payment {
    private String bankName;
    private String userID;

    public NetBanking(double amount, String bankName, String userID) {
        super( amount);
        this.bankName = bankName;
        this.userID = userID;
    }

    @Override
    public boolean transfer() {
        return false;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
