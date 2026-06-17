package com.tss.test;

import java.util.ArrayList;
import java.util.List;

public class ArrayTest {
    public static void main(String[] args) {
        List<Integer> number=new ArrayList<>();
        number.add(10);
        number.add(20);
        System.out.println(number);
        number.add(1,15);
        System.out.println("Element at 1 index : "+number.get(1));
        System.out.println("size of arrayList : "+number.size());
        number.set(1,12);
        System.out.println("Element at 1 index after update : "+number.get(1));
        List<Integer> number2=new ArrayList<>();
        number2.add(30);
        number2.add(40);
        number.addAll(number2);
        System.out.println(number);
        number2.clear();
        System.out.println("Have element 10 : "+number.contains(10));
        System.out.println("index of 20 : "+number.indexOf(20));
    }
}
