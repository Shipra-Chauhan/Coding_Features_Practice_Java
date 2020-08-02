package com.practice.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.streams.student.Student;

public class StreamsPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Student> stdList = new ArrayList<>();

		Student s1 = new Student();
		s1.setAge(21);
		s1.setName("Shipra");
		s1.setRollNo(21);
		s1.setCity("Noida");

		Student s2 = new Student();
		s2.setAge(22);
		s2.setName("Rahul");
		s2.setRollNo(22);
		s2.setCity("Pune");

		Student s3 = new Student();
		s3.setAge(25);
		s3.setName("Rajni");
		s3.setRollNo(22);
		s3.setCity("Pune");

		stdList.add(s1);
		stdList.add(s2);
		stdList.add(s3);

		/** Get the name of students from list of student **/
		stdList.stream().map(Student::getName).forEach((p) -> System.out.println(p));

		Stream<Object> streamOfStudents = stdList.stream().map(s -> {
			System.out.println(s.getName());
			return s.getName().toUpperCase();
		});

		streamOfStudents.collect(Collectors.toList());

		/** Get the names of students comma separated **/
		String allStudents = stdList.stream().map(Student::getName).collect(Collectors.joining(","));

		System.out.println(allStudents);

		/** Check if the array contains number 12 **/
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		boolean b = Arrays.stream(a).allMatch((p) -> p == 12);
		System.out.println(b);

		/** Check if the array contains number greater than 10 **/
		boolean b1 = Arrays.stream(a).anyMatch(p -> p > 10);
		System.out.println(b1);

		/** minimum, maximum, average and total of students age **/
		DoubleSummaryStatistics statistics = stdList.stream().mapToDouble(Student::getAge).summaryStatistics();
		System.out.println("Minimum=" + statistics.getMin());
		System.out.println("Maximum=" + statistics.getMax());
		System.out.println("Total=" + statistics.getSum());
		System.out.println("Average=" + statistics.getAverage());

		/** Fetch students who live in pune and who do not live in Pune **/
		Map<Boolean, List<Student>> map = stdList.stream()
				.collect(Collectors.partitioningBy((Student s) -> "Pune".equals(s.getCity())));

		System.out.println("Students living in Pune- ");
		map.get(true).stream().forEach(p -> System.out.println(p.getName()));
		System.out.println("Students not living in Pune");
		map.get(false).stream().forEach(p -> System.out.println(p.getName()));

		// map.forEach((Boolean x, List<Student> list) -> {
		// list.stream()
		// .forEach((p)->System.out.println(x + " "+p.getName()));
		// });

		// stdList.stream().filter((Student s) ->
		// "Pune".equals(s.getCity())).forEach(p->System.out.println(p.getName()));

		/** Group Students based on their cities **/
		Map<String, List<Student>> mapCity = stdList.stream().collect(Collectors.groupingBy(Student::getCity));
		mapCity.forEach((String s, List<Student> list) -> {
			list.stream().forEach(p -> System.out.println("City = " + s + " Student= " + p.getName()));
		});

		System.out.println(mapCity);

		/** Group Students name based on their cities **/
		Map<String, Set<String>> mapCityWithName = stdList.stream().collect(
				Collectors.groupingBy(Student::getCity, Collectors.mapping(Student::getName, Collectors.toSet())));
		mapCityWithName.forEach((String s, Set<String> set) -> {
			set.stream().forEach(p -> System.out.println("City = " + s + " Name = " + p));
		});
		System.out.println(mapCityWithName);

		Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		stream.filter(i -> i % 2 == 0).forEach(System.out::println);
		
	}

}
