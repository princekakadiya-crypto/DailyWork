package com.tss.creational.abstractFactory.solution.Factory;

import com.tss.creational.abstractFactory.solution.model.Car;
import com.tss.creational.abstractFactory.solution.model.Maruti;

public class MarutiFactory implements CarFactory{
    @Override
    public Car createCar() {
        return new Maruti();
    }
}
