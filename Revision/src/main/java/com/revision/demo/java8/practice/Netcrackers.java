package com.revision.demo.java8.practice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Netcrackers {

	public static void main(String[] args) {
		
		String input = "awwcccddc";
		Map<Character, Integer> result = new HashMap<>();
		for(int i=0; i<input.length(); i++) {
			int count=1;
			for(int j=i+1; j<input.length(); j++) {
				if(input.charAt(i) == input.charAt(j)) {
					count++;
				}
			}
			result.put(input.charAt(i), count);
			
		}
		System.out.println("Final result is:" + result);
		
		
		

	}

}
