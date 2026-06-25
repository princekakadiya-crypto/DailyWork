package com.tss.creational.Builder.Solution.model;

public class House {
    private int bedroom;
    private int hall;
    private int kitchen;
    private boolean garage;

    public House(int bedroom, int hall, int kitchen, boolean garage) {
        this.bedroom = bedroom;
        this.hall = hall;
        this.kitchen = kitchen;
        this.garage = garage;
    }

    @Override
    public String toString() {
        return "House{" +
                "bedroom=" + bedroom +
                ", hall=" + hall +
                ", kitchen=" + kitchen +
                ", garage=" + garage +
                '}';
    }
}
