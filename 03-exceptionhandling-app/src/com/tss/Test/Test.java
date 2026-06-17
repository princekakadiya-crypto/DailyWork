package com.tss.Test;

public class Test {
    public static void main(String[] args) {
        int number1;
        int number2;
        try {
            number1=Integer.parseInt(args[0]);
            number2=Integer.parseInt(args[1]);

            double result=number1/number2;

            System.out.println(result);
        }
        catch (ArithmeticException e)
        {
            System.out.println("divider can not be 0");
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("You must enter two value");
        }
        catch (NumberFormatException e)
        {
            System.out.println("You must enter number");
        }
        System.out.println("Exited.");
    }
}
