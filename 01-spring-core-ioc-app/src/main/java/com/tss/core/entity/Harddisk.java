package com.tss.core.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Harddisk {
    private int capacity;

    @Autowired
    public Harddisk(@Value("360") int capacity) {
        this.capacity = capacity;
        System.out.println("inside harddisk parameterized constructor");

    }

    public Harddisk() {
        System.out.println("inside harddisk default constructor");

    }

    public int getCapacity() {
        return capacity;

    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
        System.out.println("inside harddisk capacity setter");
    }

    @Override
    public String toString() {
        return "Harddisk{" +
                "capacity=" + capacity +
                '}';
    }
}
