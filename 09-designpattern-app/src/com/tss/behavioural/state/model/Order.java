package com.tss.behavioural.state.model;

public class Order {
    private int id;
    public State state;

    public Order(int id) {
        this.id = id;
        state=new Ordered();
    }

    public void nextState()
    {
        state=state.next();
    }
    public void prevState()
    {
        state=state.prev();
    }
    public void displayState()
    {
        state.display();
    }
}
