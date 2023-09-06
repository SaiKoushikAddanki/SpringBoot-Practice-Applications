package com.revision.demo.java8.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsChallenge {
    public static void main(String[] args) {
        String[] names = { "Rylee", "Tomas", "Angelique", "Youssef", "Natalie", "Maaike", "Ella",
                "Anya", "Satish", "Antony", "Jerry", "Fatima" };
        List<String> nameList = new ArrayList<>();

        // replace with Stream: result is list with values that start with an A or a
        Predicate<String> predicate1 = a -> a.startsWith("A");
        Predicate<String> predicate2 = a -> a.startsWith("a");
        nameList = Stream.of(names).filter(predicate1.or(predicate2)).collect(Collectors.toList());
        System.out.println(nameList);

        // replace with Stream: result is the print statements of the modified elements
		/*
		 * for(int i = 0; i < names.length; i++) { if(!names[i].equals("Maaike")) {
		 * names[i] += " student"; } System.out.println(names[i]); }
		 */
        Stream.of(names)
        		.filter(a-> !a.equals("Maaike"))
        		.map(a -> a.concat(" student"))
        		.forEach(System.out::println);

        // replace with Stream: result is a new list with only Angelique and Anya in it
        // print before terminal operator
        List<String> newNamesList = new ArrayList<>(nameList);
		/*
		 * for(String name : nameList) { if(name.equals("Antony")) {
		 * newNamesList.remove(name); } System.out.println(name); }
		 * System.out.println(newNamesList);
		 */
        newNamesList = newNamesList.stream().filter(a->!a.equals("Antony")).peek(System.out::println).collect(Collectors.toList());
        System.out.println();
    }

}