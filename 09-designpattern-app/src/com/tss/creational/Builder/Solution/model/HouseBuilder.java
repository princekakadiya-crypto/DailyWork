package com.tss.creational.Builder.Solution.model;

public class HouseBuilder {
    private int bedroom;
    private int hall;
    private int kitchen;
    private boolean garage;

    public HouseBuilder bedroom(int bedroom)
    {
        this.bedroom=bedroom;
        return this;
    }

    public HouseBuilder hall(int hall)
    {
        this.hall=hall;
        return this;
    }
    public HouseBuilder kitchen(int kitchen)
    {
        this.kitchen=kitchen;
        return this;
    }
    public HouseBuilder garage(boolean garage)
    {
        this.garage=garage;
        return this;
    }
    public House build()
    {
        return new House(
                bedroom,
                hall,
                kitchen,
                garage
        );
    }
}
