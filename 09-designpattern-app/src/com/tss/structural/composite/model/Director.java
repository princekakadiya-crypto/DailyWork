package com.tss.structural.composite.model;

import com.tss.structural.composite.composite.Employee;

import java.util.ArrayList;
import java.util.List;

public class Director implements Employee {
    private String name;
    private List<Employee> employees=new ArrayList<>();
    public Director(String name) {
        this.name = name;
    }

    public void addEmployee(Employee employee)
    {
        employees.add(employee);
    }

    @Override
    public void display() {
        System.out.println("Director : "+name);

        for (Employee employee:employees)
        {
            System.out.print("\t");
            employee.display();
        }
    }
}
