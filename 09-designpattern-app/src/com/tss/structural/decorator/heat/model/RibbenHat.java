package com.tss.structural.decorator.heat.model;

public abstract class RibbenHat implements Hat{
    Hat hat;

    public RibbenHat(Hat hat) {
        this.hat = hat;
    }

    @Override
    public double getPrice() {
        return hat.getPrice();
    }
}
