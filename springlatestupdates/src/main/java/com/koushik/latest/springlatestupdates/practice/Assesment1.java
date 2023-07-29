package com.koushik.latest.springlatestupdates.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Assesment1 {

	public static void main(String[] args) {
		int[] numbers = {5,9,11,2,8,21,1,111};		
		List<String> finalList = Arrays.stream(numbers)
				.mapToObj(Integer::toString)
				.filter(a-> a.startsWith("1"))
				.sorted()
				.collect(Collectors.toList());
				
		finalList.forEach(System.out::println);

		List<Integer> listNum = List.of(20, 40, 40, 80, 77);

		listNum.stream().forEach(System.out::println);
	}

}
