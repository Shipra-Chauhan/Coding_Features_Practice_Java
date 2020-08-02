package com.practice.maps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.practice.pojo.Person;

public class BuildingBiMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Person> persons = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(BuildingBiMap.class.getResourceAsStream("People.txt")));
				Stream<String> stream = br.lines();) {
			stream.map(line -> {
				String[] s = line.split(" ");
				Person p = new Person(s[0].trim(), Integer.parseInt(s[1]), s[2].trim());
				persons.add(p);
				return p;
			}).forEach(System.out::println);
		} catch (IOException e) {
			System.out.println(e);
		}

		persons.forEach(System.out::println);

		Map<Integer, List<Person>> map1 = persons.stream().collect(Collectors.groupingBy(Person::getAge));
		map1.forEach((age,list) -> System.out.println(age + " -> " +list));
		
		Map<Integer, Map<String, List<Person>>> biMap = new HashMap<>();
		persons.forEach(
				person -> biMap.computeIfAbsent(person.getAge(), HashMap::new)
				.merge(
						person.getGender(),
						//Arrays.asList() returns unmodifiable list. Hence, used new ArrayList<>()
						new ArrayList<>(Arrays.asList(person)),  
						(l1,l2) -> {
							l1.addAll(l2);
							return l1;
						}));
		System.out.println("BiMap :");
		biMap.forEach(
					(age, m) -> System.out.println( age + " -> "+m) 
					);
	}

}
