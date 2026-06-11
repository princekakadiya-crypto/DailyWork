package com.tss.test;

import com.tss.Entity.FourWheeler;
import com.tss.Entity.TwoWheeler;
import com.tss.Entity.Vehicle;
import com.tss.Validation.InputValidation;

public class VehicleTest {
    public static void main(String[] args) {
        Vehicle vehicle;
        String name= InputValidation.readName("Enter name : ");
        String companyName=InputValidation.readName("Enter Company Name : ");
        double price=InputValidation.readDouble("Enter Price : ",1);
        while (true)
        {
            System.out.println("1 for Two Wheeler ");
            System.out.println("2 for Four Wheeler");
            try
            {
                int accountType= InputValidation.readInt("Enter Vehicle type (1/2) : ");
                if (accountType==1)
                {
                    int mileage=InputValidation.readInt("Enter Mileage : ",1);
                    vehicle=new TwoWheeler(name,companyName,price,mileage);
                    break;
                } else if (accountType==2) {
                    int numberOfSeats=InputValidation.readInt("Enter Number Of Seats : ",1);
                    vehicle=new FourWheeler(name,companyName,price,numberOfSeats);
                    break;
                }
                System.out.println("Invalid choice");
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
        System.out.println(vehicle);
    }
}
