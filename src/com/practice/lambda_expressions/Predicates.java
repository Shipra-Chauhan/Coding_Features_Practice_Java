package com.practice.lambda_expressions;

import java.util.function.Predicate;

public class Predicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Predicate<String> p1 = s -> s.length() > 20;
		Predicate<String> p2 = s -> s.length() >30;
		
		Predicate<String> p3 = p1.and(p2);
		//Predicate<String> i = Predicate.isEqual()
	}

}
