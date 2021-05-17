package com.revision.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Five {
	
	public static int countStudents(List<Integer> height) {
		List<Integer> a = new ArrayList<>();
		a.addAll(height);
		int count=0;
		height.sort(null);
		for(int i=0; i<height.size(); i++) {
			if(a.get(i)!= height.get(i)) {
				++count;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		
		/*
		 * Scanner sc= new Scanner(System.in); int arraySize = sc.nextInt();
		 * List<Integer> height = new ArrayList<>(); for(int i=0; i<arraySize; i++) {
		 * height.add(sc.nextInt()); }
		 * 
		 * System.out.println(countStudents(height)); sc.close();
		 */
		
		PriorityQueue<Integer> tree = new PriorityQueue<>();
		tree.add(6);
		tree.add(4);
		tree.add(1);
		tree.add(3);
		tree.add(5);
		tree.add(2);
		Integer val = null;
		while((val=tree.poll())!=null) {
			System.out.println(val+"");
		ArrayList<String> list = new ArrayList<>(10);
		list.add("Ann");
		list.add("Bob");
		list.add("Eve");
		System.out.println(list.size());
		
		
		
		
		}

	}

}
