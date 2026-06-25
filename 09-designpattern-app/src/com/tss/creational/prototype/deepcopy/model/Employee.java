package com.tss.creational.prototype.deepcopy.model;

public class Employee{
    private String name;
    private int age;
    private Address address;

    public Employee(String name, int age,Address address) {
        this.name = name;
        this.age = age;
        this.address=address;
    }

    public Employee clone()
    {
        Address addressCopy=new Address(address.getCity());
        return new Employee(name,age,addressCopy);

    }
    public Address getAddress()
    {
        return address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
