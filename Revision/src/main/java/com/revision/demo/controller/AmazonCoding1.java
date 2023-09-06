package com.revision.demo.controller;

import java.util.ArrayList;
import java.util.List;

public class AmazonCoding1 {

	public static void main(String[] args) {
		List<Integer> skills = new ArrayList<Integer>();
		List<Integer> skills1 = new ArrayList<Integer>();
		skills.add(12);
		skills.add(4);
		skills.add(6);
		skills.add(13);
		skills.add(5);
		skills.add(10);
		skills1.add(4);
		skills1.add(8);
		skills1.add(5);
		skills1.add(6);
		System.out.println(setRating(6, skills , 3, 4, 10));
		System.out.println(setRating(4, skills1 , 1, 5, 7));

	}
	
	public static int setRating(int num, List<Integer> skills, int minAssociates, int minLevel, int maxLevel) {
		List<Integer> criteria = canFormTeam(minLevel, maxLevel, skills);
		System.out.println(criteria.size());
		/*
		 * int f1,f2, totalobjects=minAssociates, selectedobject= criteria.size(),
		 * permutation; f1 = totalobjects; for (int i = totalobjects - 1; i >= 1; i--) {
		 * f1 = f1 * i; } int number; number = totalobjects - selectedobject; f2 =
		 * number; for (int i = number - 1; i >= 1; i--) { f2 = f2 * i; } permutation =
		 * f1 / f2; return (permutation);
		 */
		int i,fact=1, size=criteria.size();  
		  int number=criteria.size();
		  for(int j=criteria.size(); j>minAssociates && size>0; j--) {
			  for(i=1;i<=number;i++){    
			      fact=fact*i;    
			  } 
			  size--;
		  }
		  return fact;
	}
	
    static List<Integer> canFormTeam(int n, int m, List<Integer> skills)
    {
    	List<Integer> criteria = new ArrayList<Integer>();
     
        for(int skill:skills) {
        	if(skill>=n && skill<=m)
        	criteria.add(skill);
        }
     return criteria;
    }    

}
