package com.tss.test;

import java.util.*;
import java.util.stream.Collectors;

public class StringStreamTest {
    public static void main(String[] args) {
        List<String> students = Arrays.asList(
                "Amit Tiwari",
                "Rahul Sharma",
                "Sneha Patil",
                "Ankit Verma",
                "Ravi Kumar",
                "Amit Tiwari",
                "Pooja Mehta",
                "Neha Singh"
        );

        //1
        students.stream().forEach(System.out::println);
        System.out.println();

        //2
        long count=students.stream().count();
        System.out.println("Student Count : "+count);
        System.out.println();

        //3
        List<String> uniqeName= students.stream().distinct().collect(Collectors.toList());
        uniqeName.stream().forEach(System.out::println);
        System.out.println();

        //4
        students.stream().sorted((name1,name2)-> name1.compareTo(name2)).forEach(System.out::println);
        System.out.println();

        //5
        students.stream().sorted((name1,name2)-> name2.compareTo(name1)).forEach(System.out::println);
        System.out.println();

        //6
        students.stream().filter((name)->name.charAt(0)=='A').forEach(System.out::println);
        System.out.println();

        //7
        students.stream().filter((name)->name.length()>10).forEach(System.out::println);
        System.out.println();

        //8
        List<String> upperName = students.stream().map((name)->name.toUpperCase()).collect(Collectors.toList());
        upperName.stream().forEach(System.out::println);
        System.out.println();

        //9
        List<String> lowerName = students.stream().map((name)->name.toLowerCase()).collect(Collectors.toList());
        lowerName.stream().forEach(System.out::println);
        System.out.println();

        //10
        List<String> firstName = students.stream().map((name)->name.split(" ")[0]).collect(Collectors.toList());
        firstName.stream().forEach(System.out::println);
        System.out.println();

        //11
        long countUnique= students.stream().distinct().count();
        System.out.println("Unique name count : "+countUnique);

        //12
        String longName=students.stream().max((name1,name2)->name1.length()-name2.length()).get();
        System.out.println("shortest name : "+longName);

        //13
        String shortName=students.stream().min((name1,name2)->name1.length()-name2.length()).get();
        System.out.println("shortest name : "+shortName);

        //14
        long totalCharacter=students.stream().mapToInt((name)->name.length()).sum();
        System.out.println("Total Character : "+totalCharacter);

        //15
        double averageLength=students.stream().mapToInt((name)->name.length()).average().getAsDouble();
        System.out.println("Average Character : "+averageLength);

        //16
        Map<String,Long> countMap=students.stream().collect(Collectors.groupingBy(name->name, Collectors.counting()));
        System.out.println(countMap);
        System.out.println();

        //17
        List<String> duplicateName=students.stream().collect(Collectors.groupingBy((name)->name, Collectors.counting())).entrySet().stream().filter((student)->student.getValue()>1).map(Map.Entry::getKey).collect(Collectors.toList());
        duplicateName.stream().forEach(System.out::println);

        //18
        Map<Character,List<String>> groupByFirstLetter= students.stream().collect(Collectors.groupingBy((name)->name.charAt(0)));
        System.out.println(groupByFirstLetter);

        //19
        Map<String,String> group=students.stream().collect(Collectors.toMap((name)->name.split(" ")[0],(name)->name.split(" ")[1],(oldvalue,newvalue)->newvalue));
        System.out.println(group);

        //20
        Map<Boolean,List<String>> mapByLength=students.stream().collect(Collectors.partitioningBy(name->name.length()>10));
        System.out.println(mapByLength);

        //21
        String nameOfStudent = students.stream().distinct().sorted().collect(Collectors.joining(", "));
        System.out.println(nameOfStudent);

        //22
        String hightsVowel=students.stream().max(Comparator.comparingInt(name->(int)name.toLowerCase().chars().filter(ch->"aeiou".indexOf(ch)!=-1).count())).orElse(null);
        System.out.println("Heights vowel in name : "+hightsVowel);

        //23
        String secondHeightName=students.stream().distinct().sorted((name1,name2)->name2.length()-name1.length()).skip(1).findFirst().orElse(null);
        System.out.println("Second Longest Name : "+secondHeightName);

        //24
        Map<Character,Long> frequencyMap=students.stream().flatMap(name->name.chars().mapToObj(ch->(char)ch)).filter(ch->ch!=' ').collect(Collectors.groupingBy(ch->ch,Collectors.counting()));
        frequencyMap.forEach((ch,count1)-> System.out.println(ch+"->"+count1));

        //25
        int totalCharacterInName=students.stream().map(name->name.length()).reduce(0,(number1,number2)->number1+number2);
        System.out.println("Total Character : "+totalCharacter);

        //1
        Map<Integer,List<String>> studentLengthMap=students.stream().collect(Collectors.groupingBy(name->name.length()));
        studentLengthMap.forEach((length,name)-> System.out.println(length+" -> "+name));

        //2
        students.stream().filter(name->name.charAt(0)==name.split(" ")[1].charAt(0)).forEach(System.out::println);

        //3
        String mostFrequentName=students.stream().collect(Collectors.groupingBy(name->name,Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
        System.out.println("Most Frequent Name : "+mostFrequentName);
        System.out.println();

        //4
        students.stream().sorted((name1,name2)->name1.length()-name2.length()).forEach(System.out::println);
        System.out.println();
        students.stream().sorted((name1,name2)->name1.compareTo(name2)).forEach(System.out::println);
        System.out.println();

        //5
        students.stream().distinct().sorted().map(name->name.split(" ")[0]).forEach(System.out::println);

    }
}
