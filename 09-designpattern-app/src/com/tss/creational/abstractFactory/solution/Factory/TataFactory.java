package com.tss.creational.abstractFactory.solution.Factory;

import com.tss.creational.abstractFactory.solution.model.Car;
import com.tss.creational.abstractFactory.solution.model.Tata;

public class TataFactory implements CarFactory{
    @Override
    public Car createCar() {
        return new Tata();
    }
}
