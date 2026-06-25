package com.tss.structural.decorator.heat.model;

public class SilverRibben extends RibbenHat{
    public SilverRibben(Hat hat) {
        super(hat);
    }

    @Override
    public double getPrice() {
        return super.getPrice()+30;
    }
}
