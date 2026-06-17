package com.tss.InterfacePractice.Test;

import com.tss.InterfacePractice.Entity.Account;
import com.tss.InterfacePractice.Entity.Demo;

public class demoTest {
    public static void main(String[] args) {
        Account account=new Demo();

        account.show();
        account.print();
        Account.print3();
    }
}
