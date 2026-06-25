package com.tss.creational.Factory.solution.Test;

import com.tss.creational.Factory.solution.Enumration.CarTypeEnum;
import com.tss.creational.Factory.solution.Factory.CarFactory;
import com.tss.creational.Factory.solution.model.Car;

public class CarTest {
    public static void main(String[] args) {
        Car car1= CarFactory.createCar(CarTypeEnum.Hyundai);
        System.out.println(car1);
        Car car2=CarFactory.createCar(CarTypeEnum.Tata);
        System.out.println(car2);
        Car car3=CarFactory.createCar(CarTypeEnum.Maruti);
        System.out.println(car3);
    }
}
