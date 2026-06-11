package com.tss.Entity;

public class BoxWeight extends Box{
    private double weight;

    public BoxWeight(double height, double width, double depth, double weight) {
        super(height, width, depth);
        this.weight = weight;
        System.out.println("con of boxWeight");

    }

    @Override
    public void show() {
        System.out.println("Inside Box Weight");
    }

    @Override
    public String toString() {
        return "BoxWeight{" +
                " height="+getHeight()+
                " width="+getWidth()+
                " depth="+getDepth()+
                " weight=" + weight +
                '}';
    }
    static
    {
        System.out.println("static block of box Weight");
    }
}
