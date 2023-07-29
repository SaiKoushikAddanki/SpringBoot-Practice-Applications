package com.epam.practice.oops;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import com.epam.practice.model.Employee;

public class CollectionsAndGenericsPractice {

	static Character[] cha = { 'a', 'b', 'c', 'd' };
	static Integer[] ints = { 23, 65, 54, 76 };
	static String[] str = { "koushik", "sujith", "Sai", "Vamsi" };

	static <T> List<T> arrToList(T[] arr) {
		List<T> list = new ArrayList<>();
		for (T o : arr) {
			list.add(o);
		}
		return list;
	}

	static List<String> getListOfString(String... strs) {
		List<String> newList = new ArrayList<>();
		for (String str : strs) {
			newList.add(str);
		}
		return newList;
	}
	
	static void getOutput(List<? extends Cards> list) {
		System.out.println(list);
	}

	public static void main(String[] args) {
		List<Character> chaList = arrToList(cha);
		List<Integer> intsList = arrToList(ints);
		List<String> strList = arrToList(str);
		System.out.println(chaList.toString() + intsList + strList);
		System.out.println(getListOfString("koushik", "Sai", "Addanki", "Hello"));
		Queue<String> queue = new LinkedList<>();
		List<String> arrayList = new ArrayList<>();
		queue.add("Name");
		queue.add("Letter");
		queue.add("Age");
		queue.clear();
		arrayList.add("koushik");
		arrayList.add("k");
		arrayList.add(1, "27");
		arrayList.add(null);
		arrayList.add(null);
		System.out.println(queue);
		System.out.println("Array list before shuffle" + arrayList);
		Collections.shuffle(arrayList);
		System.out.println("Array list after shuffle is: " + arrayList);
		Deque<Integer> deque = new ArrayDeque<>();
		deque.offer(10);
		deque.add(20);
		deque.add(12);
		System.out.println(deque.peek());
		System.out.println(deque.poll());
		System.out.println(deque.pop());
		System.out.println(deque);
		
		SortedSet<String> sortedSet = new TreeSet<>();
		sortedSet.add("Koushik");
		sortedSet.add("koushik");
		sortedSet.add("Addanki");
		sortedSet.add("Sai");
		System.out.println(sortedSet);
		
		SortedMap<StringBuilder, Integer> sortedMap = new TreeMap<>();
		StringBuilder strBu1 = new StringBuilder("test");
		StringBuilder strBu2 = new StringBuilder("test");
		StringBuilder strBu3 = new StringBuilder("test");
		strBu1.append(1);
		strBu2.append(2);
		strBu3.append(3);
		sortedMap.put(strBu1, 80);
		sortedMap.put(strBu2, 95);
		sortedMap.put(strBu3, 86);
		System.out.println("Tree map : "+ sortedMap);
		Set<StringBuilder> keySet = sortedMap.keySet();
		Set<Entry<StringBuilder,Integer>> entrySet = sortedMap.entrySet();
		Iterator<StringBuilder> iterator = keySet.iterator();
		Iterator<Entry<StringBuilder, Integer>> iterator2 = entrySet.iterator();
		while (iterator.hasNext()) {
			StringBuilder value = iterator.next();
			System.out.println("key is: " + value);
		}
		while(iterator2.hasNext()) {
			Map.Entry<StringBuilder, Integer> rec = iterator2.next();
			System.out.println("Key is: " + rec.getKey() + "value is: " + rec.getValue());
		}
		
		HashSet<String> brands = new HashSet<>();
		brands.add("Tata");
		brands.add("maruthi");
		brands.add("KIA");
		brands.add("Bently");
		brands.add("Ferari");
		brands.add("Audi");
		brands.add(null);
		brands.add(null);
		System.out.println(brands);
		
		TreeSet<String> treeSet = new TreeSet<>();
		treeSet.add("Tata");
		treeSet.add("maruthi");
		treeSet.add("KIA");
		treeSet.add("Bently");
		treeSet.add("Ferari");
		treeSet.add("Audi");
		treeSet.add("audi"); //Cannot add null values
		System.out.println(treeSet);
		
	}

}
