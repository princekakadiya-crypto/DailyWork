package com.tss;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Executable;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    static Calculator calculator;
    @BeforeAll
    static void init()
    {
        calculator=new Calculator();
    }
    @Test
    void addition() {

        int actual=calculator.addition(2,2);
        assertEquals(4,actual);
    }

    @Test
    void subtraction() {
        int actual=calculator.subtraction(2,2);
        assertEquals(0,actual);
    }

    @Test
    void multiplication() {
        assertEquals(2,calculator.multiplication(2,2));
        assertEquals(6,calculator.multiplication(2,3));
    }

    @Test
    void division() {
        int actual=calculator.division(2,2);
        assertEquals(1,actual);
        assertThrowsExactly(ArithmeticException.class,
                ()-> calculator.division(2,0)
        );
    }
}