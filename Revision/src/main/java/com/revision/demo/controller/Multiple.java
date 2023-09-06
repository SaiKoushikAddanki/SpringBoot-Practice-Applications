package com.revision.demo.controller;

public class Multiple {

	public static void main(String[] args) {
		
		for(int i=0; i<=100; i++) {
			if(i%5 == 0 && i%8 == 0) {
				System.out.println( i + " fizzbuzz");
			}else if(i%5 == 0) {
				System.out.println(i +" fizz");
			}else if(i%8 == 0) {
				System.out.println(i + " buzz");
			}
		}

	}

}
