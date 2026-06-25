package com.tss.creational.prototype.deepcopy.test;

import com.tss.creational.prototype.deepcopy.model.Address;
import com.tss.creational.prototype.deepcopy.model.Employee;

public class test {
    public static void main(String[] args) {
        Address address1=new Address("Amreli");
        Employee employee1=new Employee("Prince",21,address1);
        System.out.println(employee1);
        System.out.println("Employee 1 : "+employee1.hashCode());
        System.out.println("Employee 1 address : "+employee1.getAddress().hashCode());
        System.out.println();

        Employee employee2=employee1.clone();
        System.out.println(employee2);
        System.out.println("Employee 2 : "+employee2.hashCode());
        System.out.println("Employee 2 address : "+employee2.getAddress().hashCode());
    }
}
