package com.tss.violation.test;

import com.tss.violation.model.Bird;
import com.tss.violation.model.Penguin;
import com.tss.violation.model.Sparrow;

public class BirdTest {
    public static void main(String[] args) {
        Bird bird1=new Sparrow();
        bird1.fly();

        Bird bird2=new Penguin();
        bird2.fly();
    }
}
