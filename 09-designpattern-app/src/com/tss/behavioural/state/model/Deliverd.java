package com.tss.behavioural.state.model;

public class Deliverd implements State {
    @Override
    public State next() {
        return this;
    }

    @Override
    public State prev() {
        return new Shifting();
    }

    @Override
    public void display() {
        System.out.println("State : Deliverd");
    }
}
