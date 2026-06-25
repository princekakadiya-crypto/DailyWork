package com.tss.creational.prototype.test;

import com.tss.creational.prototype.model.Employee;

public class test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employee employee1=new Employee("prince",21);
        System.out.println(employee1);
        System.out.println(employee1.hashCode());

        Employee employee2=employee1.clone();
        System.out.println(employee2);
        System.out.println(employee2.hashCode());
    }
}
