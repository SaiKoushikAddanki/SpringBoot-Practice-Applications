package com.epam.practice.java8.practice;

public class BinarySearch {

	public static void main(String[] args) {

		int arr[] = { 10, 20, 30, 40, 50 };
		String[] str = {"koushik", "Addanki", "Sai" };
		int key = 60;
		System.out.println(str[1].compareTo(str[2]));
		int last = arr.length - 1;
		binarySearch(arr, 0, last, key);
	}

	private static void binarySearch(int[] arr, int i, int last, int key) {
		int mid = (i + last) / 2;
		while (i <= last) {
			if (arr[mid] < key) {
				i = mid + 1;
			} else if (arr[mid] == key) {
				System.out.println("Element found at index: " + mid);
				break;
			} else {
				last = mid - 1;
			}
			mid = (i + last) / 2;
		}
		if (i > last) {
			System.out.println("Element not found");
		}

	}

}
