package com.tss.Entity;

public class Demo {
    private int a;
    private static int b;

    public Demo()
    {
        a=0;
        b=0;
        System.out.println("con");
    }
    public void increment()
    {
        a++;
        b++;
    }
    public void show()
    {
        System.out.println("A = "+a);
        System.out.println("B = "+b);
    }
    static
    {
        System.out.println("static block of Demo");
    }


}
