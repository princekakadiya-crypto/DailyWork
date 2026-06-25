package com.tss.structural.decorator.test;

import com.tss.structural.decorator.model.*;

public class test {
    public static void main(String[] args) {
        ICarService carService=new CarInspection();
        CarServiceDecorator oilChange=new OilChange(carService);
        WheelAlign wheelAlign=new WheelAlign(oilChange);
        System.out.println(wheelAlign.getCost());
    }
}
