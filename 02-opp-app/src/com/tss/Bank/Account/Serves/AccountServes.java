package com.tss.Bank.Account.Serves;

import com.tss.Bank.Account.Entity.Account;
import com.tss.Bank.Account.Entity.CurrentAccount;
import com.tss.Bank.Account.Entity.SavingAccount;
import com.tss.Bank.Payment.Entity.Payment;
import com.tss.Bank.Payment.Serves.PaymentServes;
import com.tss.Validation.InputValidation;

import java.util.ArrayList;
import java.util.List;

public class AccountServes {
    List<Account> accounts = new ArrayList<>();
    List<Payment> payments=new ArrayList<>();

    public void start() {
        int choice = 0;
        do {
            System.out.println("1 for Create Account");
            System.out.println("2 for Withdraw");
            System.out.println("3 for Deposit");
            System.out.println("4 for Check Account Details");
            System.out.println("5 for Transfer");
            System.out.println("6 for Exit");

            choice = InputValidation.readInt("Enter your Choice");
            int attempt=0;
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    do {
                        String accountNumber = String.valueOf(InputValidation.readInt("Enter Account Number : "));
                        int indexOfAccount = findIndexByAccount(accountNumber);
                        if (indexOfAccount == -1) {
                            attempt++;
                            if (attempt>2)
                                break;
                            System.out.println("Invalid Account Number. "+(3-attempt)+" attempt left");
                        } else {
                            int amount = InputValidation.readInt("Enter Amount : ", 1);
                            accounts.get(indexOfAccount).withdraw(amount);
                            System.out.println(amount+" Amount Withdraw.");
                            break;
                        }
                    } while (true);
                    break;
                case 3:
                    do {
                        String accountNumber = String.valueOf(InputValidation.readInt("Enter Account Number : "));
                        int indexOfAccount = findIndexByAccount(accountNumber);
                        if (indexOfAccount == -1) {
                            attempt++;
                            if (attempt>2)
                            {
                                System.out.println("Transaction Failed");
                                break;
                            }
                            System.out.println("Invalid Account Number. "+(3-attempt)+" attempt left");
                        } else {
                            int amount = InputValidation.readInt("Enter Amount : ", 1);
                            accounts.get(indexOfAccount).deposit(amount);
                            System.out.println(amount+" Amount Deposit");
                            break;
                        }
                    } while (true);
                    break;
                case 4:
                    do {
                        String accountNumber = String.valueOf(InputValidation.readInt("Enter Account Number : "));
                        int indexOfAccount = findIndexByAccount(accountNumber);
                        if (indexOfAccount == -1) {
                            attempt++;
                            if (attempt>2)
                            {
                                System.out.println("Transaction Failed");
                                break;
                            }
                            System.out.println("Invalid Account Number. "+(3-attempt)+" attempt left");
                        } else {
                            accounts.get(indexOfAccount).printDetail();
                            break;
                        }
                    } while (true);
                    break;
                case 5:
                    String fromAccountNumber;
                    String toAccountNumber;
                    int indexOfAccountFrom;
                    int indexOfAccountTo;
                    do {
                        fromAccountNumber = String.valueOf(InputValidation.readInt("Enter Account Number From Transfer : "));
                        indexOfAccountFrom = findIndexByAccount(fromAccountNumber);
                        if (indexOfAccountFrom == -1) {
                            attempt++;
                            if (attempt>2)
                                break;
                            System.out.println("Invalid Account Number. "+(3-attempt)+" attempt left");
                        }
                        else
                            break;
                    } while (true);
                    if (attempt>2)
                    {
                        System.out.println("Transfer Failed.");
                        break;
                    }
                    attempt=0;
                    do {
                        toAccountNumber = String.valueOf(InputValidation.readInt("Enter Account Number TO Transfer : "));
                        indexOfAccountTo = findIndexByAccount(toAccountNumber);
                        if (indexOfAccountTo == -1) {
                            attempt++;
                            if (attempt>2)
                                break;
                            System.out.println("Invalid Account Number. "+(3-attempt)+" attempt left");
                        }
                        else
                            break;
                    }while (true);
                    if (attempt>2) {
                        System.out.println("Transfer Failed.");
                        break;
                    }

                    PaymentServes paymentServes=new PaymentServes();
                    payments.add(paymentServes.Pay());
                    int paymentIndex=payments.size()-1;
                    boolean flag=accounts.get(indexOfAccountFrom).withdraw(payments.get(paymentIndex).getAmount());
                    if (!flag) {
                        System.out.println("Transfer Failed.");
                        payments.get(paymentIndex).setStatus("failed");
                        break;
                    }
                    accounts.get(indexOfAccountTo).deposit(payments.get(paymentIndex).getAmount());
                    System.out.println("Transfer of Amount "+payments.get(paymentIndex).getAmount()+" complete from "+fromAccountNumber+" to "+toAccountNumber);
                    break;
                case 6:
                    System.out.println("Exited...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 6);
    }

    private int findIndexByAccount(String accountNumber) {
        for (int i=0;i<accounts.size();i++)
        {
            if (accountNumber.equals(accounts.get(i).getAccountNumber()))
                return i;
        }
        return -1;
    }

    private void createAccount() {
        String name=InputValidation.readName("Enter Name : " );
        double balance=InputValidation.readDouble("Enter Amount : ",500);
        String accountType;
        while (true)
        {
            System.out.println("1 for Saving Account ");
            System.out.println("2 for Current Account");
            try
            {
                int account= InputValidation.readInt("Enter Account Type (1/2) : ");
                if (account==1)
                {
                    accountType="Saving Account";
                    double minimumBalance=InputValidation.readDouble("Enter Minimum Balance Amount : ",0,"Minimum 0 balance required.",balance,"You can not set Minimum balance more then your deposit");
                    accounts.add(new SavingAccount(name,balance,accountType,minimumBalance));
                    break;
                } else if (account==2) {
                    accountType="Current Account";
                    double overDraft=InputValidation.readDouble("Enter OverDraft Amount : ",0);
                    accounts.add(new CurrentAccount(name,balance,accountType,overDraft));
                    break;
                }
                System.out.println("Invalid choice");
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
        System.out.println("Account Created.. Account Number is "+accounts.get(accounts.size()-1).getAccountNumber());
    }
}

