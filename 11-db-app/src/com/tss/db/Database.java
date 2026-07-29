package com.tss.db;

import com.tss.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    Connection connection;
    private static Database database=new Database();
    private Database(){
        connect();
    }

    public static Database getDatabase(){
        return database;
    }

    public Connection getConnection(){
        return connection;
    }

    private void connect() {
        try {
            //1.register drive
            Class.forName("org.postgresql.Driver");
            //2.connect to database
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/first_db", "postgres", "Temp@123456");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
