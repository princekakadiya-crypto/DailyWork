package com.tss.behavioural.state.model;

public interface State {
    public State next();
    public State prev();
    public void display();
}
