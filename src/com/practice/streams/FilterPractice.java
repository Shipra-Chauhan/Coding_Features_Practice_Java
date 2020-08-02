package com.practice.streams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FilterPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stream<String> stream = Stream.of("one", "two", "three", "four", "five");
		Predicate<String> p1 = s -> s.length() > 3;
		Predicate<String> p2 = Predicate.isEqual("two");
		Predicate<String> p3 = Predicate.isEqual("three");
		// stream.filter(p1.and(p2.or(p3))).forEach(System.out::println);

		List<String> res = new ArrayList<>();
		// stream.peek(System.out::println).filter(p1).peek(res::add); //peek is
		// intermediary operation
		stream.peek(System.out::println).filter(p1).forEach(res::add); // forEach is final operation
		System.out.println("Done!");
		System.out.println("Size =" + res.size());

	}

}
