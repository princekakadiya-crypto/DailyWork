package com.tss.Entity;

public class Box {
    private double height;
    private double width;
    private double depth;

    public Box()
    {
        height=10;
        width=20;
        depth=30;
    }
    public Box(double height,double width,double depth)
    {
        this.height=height;
        this.width=width;
        this.depth=depth;
        System.out.println("con of box");

    }

    public void show()
    {
        System.out.println("Inside Box");
    }
    static
    {
        System.out.println("static block of box");
    }

    public void initializeBox()
    {
        height=10;
        width=20;
        depth=30;
    }
    public double calculateArea()
    {
        return height*width*depth;
    }
    public void printBox()
    {
        System.out.println("Height : "+height);
        System.out.println("Width : "+width);
        System.out.println("Depth : "+depth);
    }

    public double getDepth() {
        return depth;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
