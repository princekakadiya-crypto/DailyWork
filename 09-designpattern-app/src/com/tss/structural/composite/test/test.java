package com.tss.structural.composite.test;

import com.tss.structural.composite.composite.Employee;
import com.tss.structural.composite.model.Developer;
import com.tss.structural.composite.model.Director;
import com.tss.structural.composite.model.Manager;

public class test {
    public static void main(String[] args) {
        Employee developer1=new Developer("abc");
        Employee developer2=new Developer("xyz");

        Manager manager1=new Manager("pqr");

        manager1.addEmployee(developer1);
        manager1.addEmployee(developer2);

        manager1.display();

        Director director=new Director("def");
        director.addEmployee(manager1);
        System.out.println();
        director.display();
    }
}
