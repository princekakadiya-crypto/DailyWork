package com.tss.structural.decorator.heat.test;

import com.tss.structural.decorator.heat.model.*;

public class test {
    public static void main(String[] args) {
        Hat hat=new Standard();
        GoldenRibben goldenRibben=new GoldenRibben(hat);
        System.out.println("Standard with Golden Ribben : "+goldenRibben.getPrice());

        Hat hat2=new Prominient();
        GoldenRibben goldenRibben1=new GoldenRibben(hat2);
        SilverRibben silverRibben=new SilverRibben(goldenRibben1);
        System.out.println("Prominient with Golden & Silver Ribben : "+silverRibben.getPrice());
    }
}
