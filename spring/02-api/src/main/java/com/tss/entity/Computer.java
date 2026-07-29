package com.tss.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Computer {
    @Value("Apple")
    private String company;
    private Harddisk harddisk;

    public Computer() {
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Harddisk getHarddisk() {
        return harddisk;
    }

    @Autowired
    public void setHarddisk(Harddisk harddisk) {
        this.harddisk = harddisk;
    }
}
