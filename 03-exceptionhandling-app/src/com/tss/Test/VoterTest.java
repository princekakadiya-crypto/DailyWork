package com.tss.Test;

import com.tss.Exception.AgeInvalidException;
import com.tss.model.Voter;

public class VoterTest {
    public static void main(String[] args) {
        try {
            Voter voter=new Voter(1,"Prince",15);
            System.out.println(voter);
        } catch (AgeInvalidException e) {
            System.out.println(e);
        }
        System.out.println("Exited");
    }
}
