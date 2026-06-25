package com.tss.structural.decorator.heat.model;

public class GoldenRibben extends RibbenHat{
    public GoldenRibben(Hat hat) {
        super(hat);
    }

    @Override
    public double getPrice() {
        return super.getPrice()+50;
    }
}
