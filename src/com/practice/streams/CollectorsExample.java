package com.practice.streams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.practice.pojo.Person;

public class CollectorsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Person> persons = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(CollectorsExample.class.getResourceAsStream("People.txt")));
				Stream<String> stream = br.lines();) {
			stream.map(line -> {
				String[] s = line.split(" ");
				Person p = new Person(s[0].trim(), Integer.parseInt(s[1]));
				persons.add(p);
				return p;})
			.forEach(System.out::println);
			} catch (IOException e) {
				System.out.println(e);
			}
		
		Stream<Person> stream = persons.stream();
		Optional<Person> opt = 
		stream.filter( p -> p.getAge() >= 20)
			  .min(Comparator.comparing(Person::getAge));
		System.out.println(opt);
		
		Optional<Person> opt2 =
		persons.stream().max(Comparator.comparing(Person::getAge));
		System.out.println(opt2);
		
		Map<Integer, Long> map = persons.stream().
				collect(Collectors.groupingBy(Person::getAge,
				Collectors.counting() //downstream Collector
				));
		System.out.println(map);
		
		Map<Integer, List<String>> mapName = persons.stream().
				collect(Collectors.groupingBy(Person::getAge,
				Collectors.mapping(Person::getName, Collectors.toList()) //downstream Collector
				));
		System.out.println(mapName);
		
		Map<Integer, Set<String>> map3 = persons.stream().
				collect(Collectors.groupingBy(Person::getAge,
				Collectors.mapping(Person::getName, Collectors.toCollection(TreeSet::new)) //downstream Collector
				));
		System.out.println(map3);
		
		Map<Integer, String> map4 = persons.stream().
				collect(Collectors.groupingBy(Person::getAge,
				Collectors.mapping(Person::getName, Collectors.joining(",")) //downstream Collector
				));
		System.out.println(map4);
		}
}
