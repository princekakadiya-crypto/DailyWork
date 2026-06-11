package com.tss.test;

import com.tss.Entity.Circle;
import com.tss.Entity.Rectangle;
import com.tss.Entity.Shape;

public class ShapeTest {
    public static void main(String[] args) {
        Shape circle=new Circle(5);
        circle.calculateArea();

        Shape rectangle=new Rectangle(10,20);
        rectangle.calculateArea();
    }
}
