package com.tss.Entity;

public class Rectangle implements Shape{
    private int width;
    private int height;

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public void calculateArea() {
        System.out.println("Area of Rectangle is : "+(2*width*height));
    }
}
