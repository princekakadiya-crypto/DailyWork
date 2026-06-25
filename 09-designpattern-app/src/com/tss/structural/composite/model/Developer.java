package com.tss.structural.composite.model;

import com.tss.structural.composite.composite.Employee;

public class Developer implements Employee {
    String name;

    public Developer(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println("Developer : "+name);
    }
}
