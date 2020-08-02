package com.practice.date_and_time;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.practice.pojo.Person;

public class DateAndTimeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Person> persons = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(DateAndTimeExample.class.getResourceAsStream("People.txt")));
				Stream<String> stream = br.lines();) {

			stream.map(line -> {
				String[] s = line.split(" ");
				String name = s[0].trim();
				int year = Integer.parseInt(s[1]);
				Month month = Month.of(Integer.parseInt(s[2]));
				int day = Integer.parseInt(s[3]);
				Person p = new Person(name, LocalDate.of(year, month, day));
				persons.add(p);
				return p;
			}).forEach(System.out::println);

		} catch (Exception e) {
			// TODO: handle exception
		}

		LocalDate now = LocalDate.of(2020, Month.MAY, 14);

		persons.stream().forEach(p -> {
			Period period = Period.between(p.getDateOfBirth(), now);
			System.out.println(p.getName() + " was born " 
			+ period.get(ChronoUnit.YEARS) + " years and "
			//get returns the number of months after the above years has been computed and not total months from now 
			//that is why we use until() method for that.
			+ period.get(ChronoUnit.MONTHS) + " months ["
			// Convert years into months
			+ p.getDateOfBirth().until(now, ChronoUnit.MONTHS) + " months] ["
			+ p.getDateOfBirth().until(now, ChronoUnit.YEARS) + " years] ago.");

		});

	}

}
