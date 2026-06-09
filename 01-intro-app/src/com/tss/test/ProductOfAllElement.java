package com.tss.test;

import com.tss.validation.InputValidation;

import java.util.Scanner;

public class ProductOfAllElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        do {
            size = InputValidation.ReadInt(scanner, "Enter Number Of Elements : ");
            if (size > 0)
                break;
            else
                System.out.println("Size must be greater then 0");
        } while (true);
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = InputValidation.ReadInt(scanner, "Enter Element " + (i + 1) + " : ");
        }
        int[] prod=productExceptSelf(array);
        for (int i=0;i<prod.length;i++)
        {
            System.out.println("Element "+(i+1)+" : "+prod[i]);
        }
    }
    private static int[] productExceptSelf(int[] nums) {

        int count=0;
        int index=-1;
        int mul=1;
        int[] ans=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                count++;
                index=i;
            }
            else
                mul*=nums[i];
            if(count>1)
                return ans;
        }
        if(index==-1)
        {
            for(int i=0;i<ans.length;i++)
            {
                ans[i]=mul/nums[i];
            }
            return ans;
        }
        ans[index]=mul;
        return ans;

    }
}
