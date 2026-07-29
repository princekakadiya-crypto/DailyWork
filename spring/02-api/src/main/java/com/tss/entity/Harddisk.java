package com.tss.entity;

import org.springframework.beans.factory.annotation.Value;

public class Harddisk {
    @Value("365")
    private Integer capacity;

    public Harddisk() {
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
