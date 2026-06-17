package com.tss.model;

import com.tss.Exception.AgeInvalidException;

public class Voter {
    private long id;
    private String name;
    private int age;

    public Voter(long id, String name, int age) {
        this.id = id;
        this.name = name;
        if (age<18)
            throw new AgeInvalidException(age);
        this.age = age;
    }

    @Override
    public String toString() {
        return "Voter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age<18)
            throw new AgeInvalidException(age);
        this.age = age;
    }
}
