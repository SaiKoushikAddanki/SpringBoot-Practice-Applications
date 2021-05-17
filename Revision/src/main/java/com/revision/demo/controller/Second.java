package com.revision.demo.controller;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Second {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		String s1 = sc.nextLine().toLowerCase();
		System.out.println(s1);
		char[] chr = s1.toCharArray();
		Set s = new LinkedHashSet<String>();
		Arrays.sort(chr);	
		System.out.println(chr);
		for(int i=0; i<chr.length; i++) {
			s.add(chr[i]);
		}
		System.out.println(s);
		sc.close();
	}

}
