package com.tss.behavioural.observer.service;

import com.tss.behavioural.observer.Validation.InputValidation;
import com.tss.behavioural.observer.model.*;
import com.tss.behavioural.observer.repository.AccountRepository;

import java.util.List;

public class AccountService {
    private AccountRepository accountRepository=new AccountRepository();
    public void createAccount()
    {
        String name= InputValidation.readName("Enter Name : ");
        double balance=InputValidation.readDouble("Enter Balance : ",500);
        String mobile=InputValidation.readNumberWithLength("Enter Mobile Number : ",10,"Mobile Number must be 10 digits.",10,"Mobile Number must be 10 digits.");
        String email=InputValidation.readEmail("Enter Email");
        Account account=accountRepository.addAccount(new Account(name,balance,mobile,email));
        System.out.println("Account created with account number : "+account.getAccountNumber());
    }
    public void deposit()
    {
        String accountNumber=InputValidation.readNumberWithLength("Enter Account Number : ",8,"invalide length of Account number",12,"invalide length of Account number");
        Account account=accountRepository.getAccountByAccountNumber(accountNumber);
        if (account==null)
        {
            System.out.println("Invalid Account Number");
            return;
        }
        double amount=InputValidation.readDouble("Enter Amount :",1);
        account.deposite(amount);
        notify(account,amount+" Amount deposite on account number "+account.getAccountNumber()+"\n account Balance : "+account.getBalance());
    }
    public void withdraw()
    {
        String accountNumber=InputValidation.readNumberWithLength("Enter Account Number : ",8,"invalide length of Account number",12,"invalide length of Account number");
        Account account=accountRepository.getAccountByAccountNumber(accountNumber);
        if (account==null)
        {
            System.out.println("Invalid Account Number");
            return;
        }
        double amount=InputValidation.readDouble("Enter Amount :",1);
        if (!account.withdraw(amount))
            return;
        notify(account,amount+" Amount Withdraw on account number "+account.getAccountNumber()+"\n account Balance : "+account.getBalance());
    }
    public void notify(Account account,String message)
    {
        for (INotify notify:account.getNotifies())
        {
            notify.sendNotification(message, account);
        }
    }
    public void addSMS()
    {
        String accountNumber=InputValidation.readNumberWithLength("Enter Account Number : ",8,"invalide length of Account number",12,"invalide length of Account number");
        Account account=accountRepository.getAccountByAccountNumber(accountNumber);
        if (account==null)
        {
            System.out.println("Invalid Account Number");
            return;
        }
        List<INotify> notifies=account.getNotifies();
        for (INotify notify:notifies)
        {
            if (notify instanceof SMS)
            {
                System.out.println("It is allready added");
                return;
            }
        }
        account.addNotifies(new SMS());
        System.out.println("SMS service added....");
    }
    public void addEmail()
    {
        String accountNumber=InputValidation.readNumberWithLength("Enter Account Number : ",8,"invalide length of Account number",12,"invalide length of Account number");
        Account account=accountRepository.getAccountByAccountNumber(accountNumber);
        if (account==null)
        {
            System.out.println("Invalid Account Number");
            return;
        }
        List<INotify> notifies=account.getNotifies();
        for (INotify notify:notifies)
        {
            if (notify instanceof Email)
            {
                System.out.println("It is allready added");
                return;
            }
        }
        account.addNotifies(new Email());
        System.out.println("Email service added....");
    }
    public void addWhatsapp()
    {
        String accountNumber=InputValidation.readNumberWithLength("Enter Account Number : ",8,"invalide length of Account number",12,"invalide length of Account number");
        Account account=accountRepository.getAccountByAccountNumber(accountNumber);
        if (account==null)
        {
            System.out.println("Invalid Account Number");
            return;
        }
        List<INotify> notifies=account.getNotifies();
        for (INotify notify:notifies)
        {
            if (notify instanceof Whatsapp)
            {
                System.out.println("It is allready added");
                return;
            }
        }
        account.addNotifies(new Whatsapp());
        System.out.println("Whatsapp service added....");
    }
    public void DisplayNotification()
    {
        String accountNumber=InputValidation.readNumberWithLength("Enter Account Number : ",8,"invalide length of Account number",12,"invalide length of Account number");
        Account account=accountRepository.getAccountByAccountNumber(accountNumber);
        if (account==null)
        {
            System.out.println("Invalid Account Number");
            return;
        }
        List<INotify> notifies=account.getNotifies();
        if (notifies.isEmpty())
        {
            System.out.println("No notification service");
            return;
        }
        for (INotify notify:notifies)
        {
            notify.display();
        }
    }
}
