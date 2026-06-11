package com.tss.Entity;

public class TwoWheeler extends Vehicle {
    private double mileage;

    public TwoWheeler(String company, String name, double price, double mileage) {
        super(company, name, price);
        this.mileage = mileage;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return "TwoWheeler{" +
                " Name : "+getName()+
                " Company : "+getCompany()+
                " Price : "+getPrice()+
                " mileage : " + mileage +
                '}';
    }
}
