package com.tss.creational.abstractFactory.solution.test;

import com.tss.creational.abstractFactory.solution.Factory.HyundaiFactory;
import com.tss.creational.abstractFactory.solution.Factory.MarutiFactory;
import com.tss.creational.abstractFactory.solution.Factory.TataFactory;
import com.tss.creational.abstractFactory.solution.model.Car;

public class CarTest {
    public static void main(String[] args) {
        HyundaiFactory hyundaiFactory=new HyundaiFactory();
        MarutiFactory marutiFactory=new MarutiFactory();
        TataFactory tataFactory=new TataFactory();

        Car car1= hyundaiFactory.createCar();
        System.out.println(car1);
        Car car2=marutiFactory.createCar();
        System.out.println(car2);
        Car car3=tataFactory.createCar();
        System.out.println(car3);
    }
}
