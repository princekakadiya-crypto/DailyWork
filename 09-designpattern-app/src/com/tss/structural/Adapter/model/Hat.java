package com.tss.structural.Adapter.model;

public class Hat{
    private String shortName;
    private String longName;
    private double price;
    private double tex;

    public Hat(String shortName, String longName, double price, double tex) {
        this.shortName = shortName;
        this.longName = longName;
        this.price = price;
        this.tex = tex;
    }

    public String getShortName() {
        return shortName;
    }

    public String getLongName() {
        return longName;
    }

    public double getPrice() {
        return price;
    }

    public double getTex() {
        return tex;
    }
}
