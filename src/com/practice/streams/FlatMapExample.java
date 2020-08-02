package com.practice.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class FlatMapExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		List<Integer> list2 = Arrays.asList(3, 5, 7);
		List<Integer> list3 = Arrays.asList(2, 4, 6);
		List<List<Integer>> list = Arrays.asList(list1, list2, list3);
		System.out.println(list);

		Function<List<?>, Integer> size = List::size;
		Function<List<Integer>, Stream<Integer>> flatmapper = l -> l.stream();
		// list.stream().map(l->l.size()).forEach(System.out::println);
		// list.stream().map(size).forEach(System.out::println);

		list.stream().map(flatmapper).forEach(System.out::println);
		/*
		 * for above statement Output : [[1, 2, 3, 4, 5, 6, 7], [3, 5, 7], [2, 4, 6]]
		 * java.util.stream.ReferencePipeline$Head@3b07d329
		 * java.util.stream.ReferencePipeline$Head@41629346
		 * java.util.stream.ReferencePipeline$Head@404b9385
		 */

		list.stream().flatMap(flatmapper).forEach(System.out::println);
		/*
		 * For above statement output: 1 2 3 4 5 6 7 3 5 7 2 4 6
		 */
	}

}
