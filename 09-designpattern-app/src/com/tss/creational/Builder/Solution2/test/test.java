package com.tss.creational.Builder.Solution2.test;

import com.tss.creational.Builder.Solution2.model.House;

public class test {
    public static void main(String[] args) {
        House house=new House.Builder()
                .hall(1)
                .bedroom(2)
                .kitchen(1)
                .garage(true)
                .build();

        System.out.println(house);
    }
}
