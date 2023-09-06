package com.revision.demo.controller;

import java.util.Arrays;
import java.util.List;

public class StreamApiPractice {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Koushik", "Sai", "Addanki");
		for(String name :list) {
			if(name.equalsIgnoreCase("koushik")) {
				list.remove(0);
			}
			
		}

	}

}
