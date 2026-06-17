package com.tss.Comparator;

import com.tss.model.Account;

import java.util.Comparator;

public class BalanceComparator implements Comparator<Account> {

    @Override
    public int compare(Account o1, Account o2) {
        return (int) (o1.getBalance()-o2.getBalance());
    }
}
