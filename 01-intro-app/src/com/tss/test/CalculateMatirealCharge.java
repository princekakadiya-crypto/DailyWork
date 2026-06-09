package com.tss.test;

import java.util.Scanner;

public class CalculateMatirealCharge {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter number of Unit consumed : ");
        int unitConsumed= scanner.nextInt();

        int meter_charge=75;
        int charge;
        if (unitConsumed<=100)
        {
            charge=unitConsumed*5;
        }
        else if (unitConsumed<=250) {
            charge=unitConsumed*10;
        }
        else {
            charge=unitConsumed*20;
        }
        int total_water_bill=charge+meter_charge;
        System.out.println("Total Water Bill : "+total_water_bill);
    }
}
