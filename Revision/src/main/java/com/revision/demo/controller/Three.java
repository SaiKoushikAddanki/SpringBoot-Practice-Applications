package com.revision.demo.controller;

import java.util.Scanner;

public class Three {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int s1 = sc.nextInt();
		String s2 = sc.next();
		int s3 = sc.nextInt();
		
		for(int i=0; i<s1; i++) {
			Thread t = new Thread(s2);
			t.setPriority(s3);
			System.out.println(t);
		}
		
		sc.close();
		/*
		 * int one=0, zero =0, space =0; for(int i=0; i<s1.length(); i++) {
		 * if(s1.charAt(i) == '0') { ++zero; } else if(s1.charAt(i) == '1') { ++one; }
		 * else { ++space; } }
		 * 
		 * System.out.println(zero); System.out.println(one);
		 */
	}

}
