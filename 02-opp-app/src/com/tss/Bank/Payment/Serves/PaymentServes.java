package com.tss.Bank.Payment.Serves;

import com.tss.Bank.Payment.Entity.*;
import com.tss.Validation.InputValidation;

public class PaymentServes {

    public Payment Pay()
    {
        Payment payment=null;
        double amount= InputValidation.readDouble("Enter amount",0);
        int choice;
        do {
            System.out.println("Payment method");
            System.out.println("1 for Credit Card");
            System.out.println("2 for Debit Card");
            System.out.println("3 for UPI payment");
            System.out.println("4 for Net Banking");
            System.out.println("5 for Digital Wallet");
            System.out.println("6 for Exit");
            choice= InputValidation.readInt("Enter choice");
            switch (choice)
            {
                case 1:
                    String creditcardNumber=InputValidation.readNumberWithLength("Enter Credit card number : ",12,12,"Credit card number must be 12 digits");
                    String creditcardholderName=InputValidation.readName("Enter Holder Name : ");
                    return new CreditCard(amount,creditcardNumber,creditcardholderName);
                case 2:
                    String debitcardNumber=InputValidation.readNumberWithLength("Enter Debit card number : ",12,12,"Debit card number must be 12 digits");
                    String debitcardholderName=InputValidation.readName("Enter Holder Name : ");
                    String cvv=InputValidation.readNumberWithLength("Enter cvv : ",3,3,"cvv must be 3 digits");
                    return new DebitCard(amount,debitcardNumber,debitcardholderName,cvv);
                case 3:
                    String upiId=InputValidation.readString("Enter UPI ID : ",10,50,"Invalid input");
                    return new UPI(amount,upiId);
                case 4:
                    String bankName=InputValidation.readName("Enter BankName : ");
                    String userId=InputValidation.readNumberWithLength("Enter User ID : ",3,50,"User ID must be 3 to 50 digits");
                    return new NetBanking(amount,bankName,userId);
                case 5:
                    String walletId=InputValidation.readString("Enter Wallet Id : ",12,12,"walletID must be 12 digits");
                    String moblieNumber=InputValidation.readNumberWithLength("Enter Mobile Number : ",10,10,"Mobile number must be 10 digits");
                    return new DigitalWallet(amount,walletId,moblieNumber);
                case 6:
                    return null;
                default:
                    System.out.println("Invalid Input");
            }
        }while (true);
    }
}
