package com.tss.structural.Adapter.adepter;

import com.tss.structural.Adapter.model.Hat;
import com.tss.structural.Adapter.model.IItems;

public class HatAdepter implements IItems {
    private Hat hat;

    public HatAdepter(Hat hat) {
        this.hat = hat;
    }

    @Override
    public String getName() {
        return hat.getShortName()+" "+hat.getLongName();
    }

    @Override
    public double getPrice() {
        return hat.getPrice()+hat.getTex();
    }
}
