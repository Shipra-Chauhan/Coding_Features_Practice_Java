package com.practice.lambda_expressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class CollectionUsingLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> list = Arrays.asList("Li st", "Lambda ", "  Lion");
		//list.spliterator().forEachRemaining(l -> l.toLowerCase());
		//list.forEach(System.out::println);
		List<String> newL = new ArrayList<>();
		Consumer<String> c = System.out::println; //String::trim;
		Consumer<String> c1 =  newL::add; // 1 parameter, method called by object
		list.forEach(c.andThen(c1)); //Method Reference
		System.out.println("Size of list : "+newL.size());
	}

}
