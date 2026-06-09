package com.tss.test;

import java.util.Scanner;
import com.tss.validation.InputValidation;

public class demo {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num= InputValidation.ReadInt(scanner,"Enter Number");
    }
}
