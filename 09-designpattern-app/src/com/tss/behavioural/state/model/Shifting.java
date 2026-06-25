package com.tss.behavioural.state.model;

public class Shifting implements State{
    @Override
    public State next() {
        return new Deliverd();
    }

    @Override
    public State prev() {
        return new Ordered();
    }

    @Override
    public void display() {
        System.out.println("State : Shifting");
    }
}
