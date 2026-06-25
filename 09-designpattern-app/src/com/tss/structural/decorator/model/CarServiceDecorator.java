package com.tss.structural.decorator.model;

public abstract class CarServiceDecorator implements ICarService{
    ICarService carService;

    public CarServiceDecorator(ICarService carService) {
        this.carService = carService;
    }

    @Override
    public double getCost() {
        return carService.getCost();
    }
}
