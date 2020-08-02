package com.practice.maps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.practice.pojo.Person;

public class MergingMaps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> persons = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(MergingMaps.class.getResourceAsStream("People.txt")));
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
		
		//persons.forEach(System.out::println);
		List<Person> l1 = persons.subList(0, 5);
		List<Person> l2 = persons.subList(5, persons.size());
		
		Map<Integer, List<Person>> map1 = mapByAges(l1);
		map1.forEach((age,list) -> System.out.println("MAP 1 :\n "+ age + " -> " +list));
		Map<Integer, List<Person>> map2 = mapByAges(l2);
		map2.forEach((age,list) -> System.out.println("MAP 2 : \n"+ age + " -> " +list));
		
		//Merging map1 and map2 with same age
		map2.entrySet().stream()
				.forEach(entry -> 
				map1.merge(entry.getKey(), entry.getValue(), (list1, list2) -> {list1.addAll(list2);
				return list1;})
				);
		System.out.println("MAP 1 Merged:");
		map1.forEach((age,list) -> System.out.println(age + " -> " +list));

	}

	public static Map<Integer, List<Person>> mapByAges(List<Person> list) {
		Map<Integer, List<Person>> map = list.stream().collect(Collectors.groupingBy(Person::getAge));
		return map;
	}

}
