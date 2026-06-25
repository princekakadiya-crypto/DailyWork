package com.tss.creational.singleton.solution.test;

import com.tss.creational.singleton.solution.model.DBconnection;

public class dbConnectionTest {
    public static void main(String[] args) {
        DBconnection connection=DBconnection.createInstance();
        DBconnection connection1=DBconnection.createInstance();

        System.out.println("connection : "+connection.hashCode());
        System.out.println("connection : "+connection1.hashCode());
    }
}
