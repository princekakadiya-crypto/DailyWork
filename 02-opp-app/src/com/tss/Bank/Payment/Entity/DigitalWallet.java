package com.tss.Bank.Payment.Entity;

public class DigitalWallet extends Payment {
    private String walletId;
    private String mobileNumber;

    public DigitalWallet( double amount, String walletId, String mobileNumber) {
        super( amount);
        this.walletId = walletId;
        this.mobileNumber = mobileNumber;
    }

    @Override
    public boolean transfer() {
        return false;
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
