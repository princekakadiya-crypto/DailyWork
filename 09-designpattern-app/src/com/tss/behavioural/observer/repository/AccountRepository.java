package com.tss.behavioural.observer.repository;

import com.tss.behavioural.observer.model.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
    private static List<Account> accounts=new ArrayList<>();

    public Account addAccount(Account account)
    {
        accounts.add(account);
        return account;
    }
    public Account getAccountByAccountNumber(String accountNumber)
    {
        for (Account account:accounts)
        {
            if (account.getAccountNumber().equals(accountNumber))
                return account;
        }
        return null;
    }
}
