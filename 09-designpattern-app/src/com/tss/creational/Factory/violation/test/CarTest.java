package com.tss.creational.Factory.violation.test;

import com.tss.creational.Factory.violation.model.Car;
import com.tss.creational.Factory.violation.model.Hundai;
import com.tss.creational.Factory.violation.model.Maruti;
import com.tss.creational.Factory.violation.model.Tata;

public class CarTest {
    public static void main(String[] args) {
        Car car1=new Tata("pqr",2100000);
        System.out.println(car1);
        Car car2=new Maruti("abc",200000);
        System.out.println(car2);
        Car car3=new Hundai("xyz",510000);
        System.out.println(car3);
    }
}
