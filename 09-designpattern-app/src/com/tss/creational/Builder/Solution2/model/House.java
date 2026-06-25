package com.tss.creational.Builder.Solution2.model;

import com.tss.creational.Builder.Solution.model.HouseBuilder;

public class House {
    private int bedroom;
    private int hall;
    private int kitchen;
    private boolean garage;

    private House(Builder builder) {
        this.bedroom = builder.bedroom;
        this.hall = builder.hall;
        this.kitchen = builder.kitchen;
        this.garage = builder.garage;
    }

    public static class Builder
    {
        private int bedroom;
        private int hall;
        private int kitchen;
        private boolean garage;

        public Builder bedroom(int bedroom)
        {
            this.bedroom=bedroom;
            return this;
        }

        public Builder hall(int hall)
        {
            this.hall=hall;
            return this;
        }
        public Builder kitchen(int kitchen)
        {
            this.kitchen=kitchen;
            return this;
        }
        public Builder garage(boolean garage)
        {
            this.garage=garage;
            return this;
        }
        public House build()
        {
            return new House(this);
        }
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
