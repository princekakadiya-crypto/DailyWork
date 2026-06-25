package com.tss.creational.Builder.Solution.test;

import com.tss.creational.Builder.Solution.model.House;
import com.tss.creational.Builder.Solution.model.HouseBuilder;

public class test {
    public static void main(String[] args) {
        House house= new HouseBuilder()
                .bedroom(2)
                .hall(1)
                .garage(true)
                .kitchen(1)
                .build();


        System.out.println(house);
    }
}
