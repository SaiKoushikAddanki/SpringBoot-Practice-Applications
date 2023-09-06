package com.revision.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VivekCisco {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int size = sc.nextInt();
		List<String> inp = new ArrayList<String>();
		for (int i = 0; i < size; i++) {
		 inp.add(sc.nextLine());
		}
		
		int result = expressive_cnt(s,inp);
		
	}

	private static int expressive_cnt(String s, List<String> inp) {
		int count =0;
		int[] scounts = getOccuringChar(s);
		
		for(String sample:inp) {
			if(sample.matches(s)) {
				count++;
				break;
			}
			else {
				int internalCounter=0;
				int[] sampleCounts = getOccuringChar(sample);
				for(int i=0; i<sampleCounts.length; i++) {
					if(sampleCounts[i] <= scounts[i]) {
						internalCounter++;
					}
				}
				
				if(internalCounter == sampleCounts.length)
					count++;
				
			}
		}
		return count;
	}
	
	static int[] getOccuringChar(String str)
    {
         
        // Create an array of size 256
        // i.e. ASCII_SIZE
        int count[] = new int[str.length()];
 
        int len = str.length();
 
        // Initialize count array index
        for (int i = 0; i < len; i++)
            count[str.charAt(i)]++;
 
        // Create an array of given String size
        char ch[] = new char[str.length()];
        for (int i = 0; i < len; i++) {
            ch[i] = str.charAt(i);
            int find = 0;
            for (int j = 0; j <= i; j++) {
 
                // If any matches found
                if (str.charAt(i) == ch[j])
                    find++;
            }
 
        }
        
        return count;
    }
}
