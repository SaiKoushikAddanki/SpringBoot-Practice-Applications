 package com.revision.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sample {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		int a = sc.nextInt();

		for (int i = 0; i < a; i++) {
			list.add(sc.nextInt());
		}
		for(int i=0; i+1<list.size(); i++) {
			System.out.println(i +" " + list.get(i) +" " + list.get(i+1) );
			if(coprime(list.get(i), list.get(i+1)) == 1) {
				continue;
			} else {
				int lcm = lcm(list.get(i), list.get(i+1));
				list.remove(i);
				list.add(i,lcm);
				list.remove(i+1);
				i=0;
			}
			
		}
		
		list.forEach(j -> System.out.print(j + " "));

	}

	static int __gcd(int a, int b) {
		if (a == 0 || b == 0)
			return 0;
		if (a == b)
			return a;
		if (a > b)
			return __gcd(a - b, b);
		return __gcd(a, b - a);
	}

	static int coprime(int a, int b) {

		if (__gcd(a, b) == 1)
			return 1;
		else
			return 0;
	}
	
	static int lcm(int a, int b) {
		int max, step, lcm = 0;
		if(a > b){
	         max = step = a;
	      }
	      else{
	         max = step = b;
	      }

	      while(a!= 0) {
	         if(max % a == 0 && max % b == 0) {
	            lcm = max;
	            break;
	         }
	         max += step;
	      }
		
		return lcm;
	}

}
