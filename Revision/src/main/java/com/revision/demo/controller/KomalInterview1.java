package com.revision.demo.controller;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KomalInterview1 {

	public static void main(String[] args) {

		Integer[] arr1 = { 2, 5, 7, 8 };
		Integer[] arr2 = { 25, 4, 49, 64 };
		Boolean result = true;
		for (int i = 0; i < arr1.length; i++) {
			int squaredNumber = arr1[i] * arr1[i];
			int count = 0;
			for (int j = 0; j < arr2.length; j++) {
				if (arr2[j] == squaredNumber) {
					count++;
				}
			}
			if (count == 0) {
				result = false;
				break;
			}
		}
		System.out.println(result);
		Set<Integer> result1 = Stream.of(arr1).map(a -> a * a).collect(Collectors.toSet());
		System.out.println(result1);

	}

}
