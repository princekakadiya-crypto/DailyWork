package com.tss.core.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Computer {

    private String companyName;
    private Harddisk harddisk;

    @Autowired
    public Computer(@Value("Apple") String companyName, Harddisk harddisk) {
        this.companyName = companyName;
        this.harddisk = harddisk;
        System.out.println("inside computer parameterized constructor");
    }

    public Computer() {
        System.out.println("inside computer default constructor");

    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
        System.out.println("inside computer setter company name");
    }

    public Harddisk getHarddisk() {
        return harddisk;
    }

    public void setHarddisk(Harddisk harddisk) {
        this.harddisk = harddisk;
        System.out.println("inside computer setter hardisk");
    }

    @Override
    public String toString() {
        return "Computer{" +
                "companyName='" + companyName + '\'' +
                ", harddisk=" + harddisk +
                '}';
    }
}
