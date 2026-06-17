package com.tss.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashmapTest {
    public static void main(String[] args) {
        HashMap<Integer,String> students=new HashMap<>();
        students.put(1,"abc");
        students.put(2,"pqr");
        students.put(3,"xyz");

        students.put(2,"stu");

        System.out.println(students);

        Set<Map.Entry<Integer,String>> studentEntry= students.entrySet();

        for (Map.Entry<Integer,String> student:studentEntry)
        {
            System.out.println("Key : "+student.getKey());
            System.out.println("Value : "+student.getValue());
        }
    }
}
