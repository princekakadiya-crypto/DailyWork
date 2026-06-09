package com.tss.test;

import java.util.Scanner;

public class CurrancyCalculater {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Amount :");
        int amount=scanner.nextInt();
        if(amount>50000 || amount%100!=0 || amount<0)
            System.out.println("Amount should not exceed 50000 and should always be multiple of 100");
        else
        {
            int twoThousand=0;
            while (amount>=2000)
            {
                amount-=2000;
                twoThousand++;
            }
            int fiveHondred=0;
            while (amount>=500)
            {
                amount-=500;
                fiveHondred++;
            }
            int twoHondred=0;
            while (amount>=200)
            {
                amount-=200;
                twoHondred++;
            }
            int hondred=0;
            while (amount>=100)
            {
                amount-=100;
                hondred++;
            }
            if (twoThousand>0)
                System.out.println("Two Thousand : "+twoThousand);
            if (fiveHondred>0)
                System.out.println("Five Hondred : "+fiveHondred);
            if (twoHondred>0)
                System.out.println("Two Hondred : "+twoHondred);
            if (hondred>0)
                System.out.println("Hondred : "+hondred);
        }
    }
}
