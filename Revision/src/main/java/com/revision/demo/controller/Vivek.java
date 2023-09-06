package com.revision.demo.controller;

public class Vivek {

	public static void main(String[] args) throws Exception {

		System.out.println(reveArray(new int[] {
				20,30,10,40,50
		}));
	}
	
	public static int[] reveArray(int arr[]) {
		int i,temp, originallen = arr.length -1;
		int len = originallen;
		for(i=0; i< originallen; i++) {
			temp = arr[len-1];
			arr[len-1] = arr[i];
			arr[i] = temp;
			len +=1;
		}
		return arr;
	}

}
