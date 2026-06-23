package com.tss.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        List<Integer> numbers=new ArrayList<>();
        numbers.add(10);
        numbers.add(21);
        numbers.add(30);
        numbers.add(41);
        numbers.add(50);

        numbers.stream().forEach(System.out::println);
        System.out.println();

        numbers.stream().filter((number)->number%2==0).forEach(System.out::println);
        System.out.println();

        List<Integer> squares= numbers.stream().map((number)->number*number).collect(Collectors.toList());
        squares.stream().forEach(System.out::println);
        System.out.println();

        Integer sum=numbers.stream().reduce(0,(number1,number2)->number1+number2);
        System.out.println("Sum : "+sum);

        Integer sumOfEven = numbers.stream().filter((number)->number%2==0).reduce(0,(number1,number2)->number1+number2);
        System.out.println("Sum of even : "+sumOfEven);

        Integer min=numbers.stream().min((number1,number2)->number1-number2).get();
        System.out.println("Min : "+min);

        Integer max=numbers.stream().max((number1,number2)->number1-number2).get();
        System.out.println("Max : "+max);

        numbers.stream().limit(2).forEach(System.out::println);

        long count=numbers.stream().count();
        System.out.println("Count : "+count);

        Integer first=numbers.stream().findFirst().get();
        System.out.println("First : "+first);

        boolean flag= numbers.stream().anyMatch((number)->number%2==0);
        System.out.println("Have any even : "+flag);

        //skip first two
        numbers.stream().skip(2).forEach(System.out::println);
        System.out.println();

        numbers.stream().distinct().forEach(System.out::println);
    }
}
