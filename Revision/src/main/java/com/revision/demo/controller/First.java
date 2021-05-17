package com.revision.demo.controller;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class First {

	public static void main(String[] args) {
		
		/*
		 * List<Person> personList = new ArrayList<Person>();
		 * 
		 * Person p1 = new Person(43, 23, "Koushik", "Addanki"); Person p2 = new
		 * Person(44, 26, "Sasi Preetham", "Alavala"); Person p3 = new Person(45, 27,
		 * "Akhil Varma", "Alluri"); Person p4 = new Person(72, 24, "Stickey",
		 * "Indukuri"); Person p5 = new Person(81, 32, "Choi", "Penmetsa");
		 * 
		 * personList.add(p1); personList.add(p2); personList.add(p3);
		 * personList.add(p4); personList.add(p5);
		 * 
		 * Collections.sort(personList,
		 * (p,q)->p.getFirstName().compareTo(q.getFirstName()));
		 * 
		 * for(Person p:personList) { System.out.println(p); }
		 * 
		 * //personList.stream().sorted((p1,p2) ->
		 * p1.getLastName().compareTo(p2.getLastName())).collect().forEach(personList);
		 */
		/*
		 * Deque<Integer> pq = new ArrayDeque<Integer>(10); pq.add(10); pq.add(20);
		 * pq.clear(); pq.add(15); System.out.println(pq.peek());
		 * System.out.println(pq.poll()); System.out.println(pq.peek());
		 * pq.addFirst(564); pq.addFirst(291); pq.addLast(14); Object[] arr =
		 * pq.toArray(); System.out.println(arr.length); pq.peek(); pq.poll();
		 * pq.push(265); pq.push(984); pq.remove(); System.out.println(pq);
		 */
		
		Scanner sc= new Scanner(System.in);
		Set s = new HashSet<String>();
				int a= sc.nextInt(); 
		for(int i=0; i<=a; i++) {
			s.add(sc.nextLine());
		}
		
		System.out.println(s.size());
		
		
		
		
		}

}
