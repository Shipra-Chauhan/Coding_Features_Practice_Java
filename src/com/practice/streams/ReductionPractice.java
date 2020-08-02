package com.practice.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class ReductionPractice {

	public static void main(String[] args) {

		List<Integer> ages = Arrays.asList(24, 25, 29, 45, 50, 34, 13, 18, 3);
		Stream<Integer> stream = ages.stream();
		// Integer sum = stream.reduce(0, (age1, age2) -> age1+age2);
		//Integer sum = stream.reduce(0, Integer::sum);
		// System.out.println("Sum = "+ sum);

		// Optional<Integer> max = stream.max(Comparator.naturalOrder());
		// System.out.println(max.orElse(0));

		Optional<Integer> minAge = stream
				.filter(age -> age > 20) //Stream<Integer>
				.min(Comparator.naturalOrder()); //Terminal Operation
		System.out.println(minAge);
		
		Stream<Integer> num = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		BinaryOperator<Integer> add = Integer :: sum ;//(i1, i2) -> i1 + i2;
		Integer id = 0;
		int red = num.reduce(id, add);
		System.out.println(red);

		Stream<Integer> num1 = Stream.empty();
		Stream<Integer> num2 = Stream.of(1);
		int reduce1 = num1.reduce(id, add); // Empty Stream returns ID element
		int reduce2 = num2.reduce(id, add); // Single element stream returns the element
		System.out.println(reduce1);
		System.out.println(reduce2);

	}

}
