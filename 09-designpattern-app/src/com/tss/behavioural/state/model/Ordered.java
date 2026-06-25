package com.tss.behavioural.state.model;

public class Ordered implements State{
    @Override
    public State next() {
        return new Shifting();
    }

    @Override
    public State prev() {
        return this;
    }

    @Override
    public void display() {
        System.out.println("State : Ordered");
    }
}
