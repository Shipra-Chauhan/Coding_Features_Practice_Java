package com.practice.lambda_expressions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorUsingLambda {

	public static void main(String[] args) {
		
		//Old Way
		Comparator<String> comp = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1.length(), o2.length());
			}
		};
		
		
		//New Way
		Comparator<String> comp_Lmbda = //(String o1, String o2) -> 
				(o1, o2) -> 
			Integer.compare(o1.length(), o2.length());
	

		List<String> list = Arrays.asList("*****","***","*","**");
		Collections.sort(list, comp_Lmbda);
		
		for (String s : list) {
			System.out.println(s);
		}
	}
	
}
