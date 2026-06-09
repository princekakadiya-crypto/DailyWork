package com.tss.test;

import com.tss.Entity.Box;

public class BoxTest {
    public static void main(String[] args) {
        Box box1=new Box();
        System.out.println("Area of Box 1 : "+box1.calculateArea());
        box1.printBox();

        Box box2=new Box(100,200,300);
        box2.setWidth(250);
        System.out.println("Area of Box 2 : "+box2.calculateArea());
        box2.printBox();
    }
}
