package com.tss.structural.decorator.model;

public class WheelAlign extends CarServiceDecorator{
    public WheelAlign(ICarService carService) {
        super(carService);
    }

    @Override
    public double getCost() {
        return super.getCost()+500;
    }
}
