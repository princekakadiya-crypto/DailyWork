package com.tss.Entity;

public class FourWheeler extends Vehicle {
    private int numberOfSeats;

    public FourWheeler(String company, String name, double price, int numberOfSeats) {
        super(company, name, price);
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String toString() {
        return "FourWheeler{" +
                " Name : "+getName()+
                " Company : "+getCompany()+
                " Price : "+getPrice()+
                " numberOfSeats : " + numberOfSeats +
                '}';
    }
}
