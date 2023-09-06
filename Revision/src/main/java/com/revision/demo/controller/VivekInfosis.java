package com.revision.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class VivekInfosis {
	
	List<Integer> sum = new ArrayList<Integer>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int[] arr = new int[a];
		for (int i = 0; i < a; i++) {
			arr[i] = sc.nextInt();
		}
		int result = MaximimLenght(a, arr);
		System.out.println(result);

		sc.close();
	}

	private static int MaximimLenght(int X, int[] arr) {
		for(int i=1;i<=X;i++)
		printCombination(arr, X, i);
		return 10;
	}

	static void combinationUtil(int arr[], int data[], int start, int end, int index, int r) {
		if (index == r) {
			for (int j = 0; j < r; j++)
				System.out.print(data[j] + " ");
			System.out.println("");
			return;
		}
		for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
			data[index] = arr[i];
			combinationUtil(arr, data, i + 1, end, index + 1, r);
		}
	}
	static void printCombination(int arr[], int n, int r) {
		int data[] = new int[r];
		combinationUtil(arr, data, 0, n-1, 0, r);
}

}
