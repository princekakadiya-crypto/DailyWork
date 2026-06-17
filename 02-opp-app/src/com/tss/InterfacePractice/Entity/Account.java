package com.tss.InterfacePractice.Entity;

public interface Account {
    void show();
    default void print()
    {
        System.out.println("Inside print method.");
        print2();
    }
    private void print2()
    {
        System.out.println("Inside print2 method");
    }
    static void print3()
    {
        System.out.println("Inside static method");
    }
}
