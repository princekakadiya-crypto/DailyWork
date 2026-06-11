package com.tss.Bank.Payment.Entity;


public class DebitCard extends Payment {
    private String debitCardNumber;
    private String holderName;
    private String cvv;

    public DebitCard( double amount, String debitCardNumber, String holderName,String cvv) {
        super( amount);
        this.debitCardNumber = debitCardNumber;
        this.holderName = holderName;
        this.cvv=cvv;
    }

    @Override
    public boolean transfer() {
        return false;
    }

    public String getDebitCardNumber() {
        return debitCardNumber;
    }

    public void setDebitCardNumber(String debitCardNumber) {
        this.debitCardNumber = debitCardNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
