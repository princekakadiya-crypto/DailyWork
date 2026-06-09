package com.tss.test;

import java.util.Scanner;
import com.tss.validation.InputValidation;

public class ShiftCharacterOfString {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String input="";
        int n;
        while (true) {
            System.out.println("Enter String : ");
            input = scanner.nextLine();
            boolean flag=true;
            for (char ch : input.toCharArray())
            {
                if (!(ch>='a' && ch<='z') && !(ch>='A' && ch<= 'Z'))
                {
                    System.out.println("Invalid Input Only Alphabet Allow");
                    flag=false;
                    break;
                }
            }
            if (flag) {
                n=InputValidation.ReadInt(scanner,"Enter Number of Shift : ");
                break;
            }
        }

        String shiftString="";
        for (char ch:input.toCharArray())
        {
            if (ch>='a' && ch<='z')
            {
                int pos=ch-97;
                pos=(pos+n)%26;
                if(pos<0)
                    pos+=26;
                shiftString+=(char)('a'+pos);
            }
            else if (ch>='A' && ch<='Z')
            {
                int pos=ch-65;
                pos=(pos+n)%26;
                if(pos<0)
                    pos+=26;
                shiftString+=(char)('A'+pos);
            }
        }
        System.out.println("String After Shift : "+shiftString);
    }
}
