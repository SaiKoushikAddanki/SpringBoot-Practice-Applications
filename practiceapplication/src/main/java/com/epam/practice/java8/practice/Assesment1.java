package com.epam.practice.java8.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.util.comparator.Comparators;

import com.epam.practice.model.Drinks;
import com.epam.practice.oops.DebitCards;

public class Assesment1 {

	public static void main(String[] args) {
		int[] numbers = {5,9,11,2,8,21,1,111};		
		final List<String> finalList = Arrays.stream(numbers)
				.mapToObj(Integer::toString)
				.filter(a-> a.startsWith("1"))
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
				finalList.add("Kous");
		finalList.forEach(System.out::println);
		List<String> immutableCollection = Collections.unmodifiableList(finalList);
		Integer num = 10;
		num += 20;
		System.out.println(num.byteValue());
		System.out.println(Drinks.PEPSI.getAction());
		DebitCards debitCard = new DebitCards();
		System.out.println(debitCard.getParentProperties());
		String s1 = "Hi EPAM bye EPAM goodbye EPAM welcome ePAM Hi There epAM bye bye EPaM";
		String s2 = "koushik";
		String reverse ="";
		char[] chars = s2.toCharArray();
		for(int i=chars.length-1; i>=0;i--) {
			reverse = reverse+chars[i];
		}
		StringBuilder str = new StringBuilder(s2);
		str.reverse();
		System.out.println("String builder reverse is: " + str);
		System.out.println("Reverse string is: " + reverse);
		
	}

}
