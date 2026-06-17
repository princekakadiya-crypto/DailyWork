package com.tss.test;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class InBuileFunctionalInterfaceTest {
    public static void main(String[] args) {
        //prime number
        Predicate<Integer> predicate=(number)->{
            for (int i=2;i<number/2;i++)
            {
                if (number%i==0)
                    return false;
            }
            return true;
        };
        System.out.println(predicate.test(7));

        //factorial
        Function<Integer,Integer> factorial=(number)->
        {
            int result=1;
            for (int i=2;i<=number;i++)
            {
                result*=i;
            }
            return result;
        };
        System.out.println(factorial.apply(5));

        //maximum
        BiFunction<Integer,Integer,Integer> findMaximum=(number1,number2)->{
            if (number1>number2)
                return number1;
            return number2;
        };
        System.out.println(findMaximum.apply(10,20));
    }
}
