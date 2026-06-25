package com.tss.creational.singleton.solution.model;

public class DBconnection {
    private static DBconnection instance=null;
    public static DBconnection createInstance()
    {
        if (instance==null)
            instance=new DBconnection();
        return instance;
    }
    public void display()
    {
        System.out.println("Object of singleton");
    }
}
