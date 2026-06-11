package com.tss.test;

import com.tss.Entity.Box;
import com.tss.Entity.BoxWeight;

public class BoxWeightTest {
    public static void main(String[] args) {
        Box boxWeight=new BoxWeight(10,20,30,40);
        System.out.println(boxWeight);
        boxWeight.show();
    }
}
