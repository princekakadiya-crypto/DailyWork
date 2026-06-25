package com.tss.behavioural.state.test;

import com.tss.behavioural.state.model.Order;
import com.tss.behavioural.state.model.State;

public class test {
    public static void main(String[] args) {
        Order order=new Order(1);
        order.displayState();

        order.nextState();
        order.displayState();

        order.nextState();
        order.displayState();

        order.prevState();
        order.displayState();

        order.nextState();
        order.displayState();

        order.nextState();
        order.displayState();

    }
}
