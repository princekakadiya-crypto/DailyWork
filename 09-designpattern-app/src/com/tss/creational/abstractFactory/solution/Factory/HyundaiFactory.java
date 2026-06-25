package com.tss.creational.abstractFactory.solution.Factory;

import com.tss.creational.abstractFactory.solution.model.Car;
import com.tss.creational.abstractFactory.solution.model.Hyundai;

public class HyundaiFactory implements CarFactory{
    @Override
    public Car createCar() {
        return new Hyundai();
    }
}
