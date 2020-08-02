package com.practice.functional_programming;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class FirstClassCitizenVariable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LocalDate ab = LocalDate.of(1987, Month.MARCH, 23);
		//	a.atTime(1, minute, second, nanoOfSecond)()
			System.out.println(DateTimeFormatter.ISO_ZONED_DATE_TIME.format(ZonedDateTime.of(1987, Month.MARCH.getValue(), 23, 17, 0, 0, 0, ZoneId.of("Europe/London"))));
			//of(ab, LocalTime.of(17, 0, 0, 0), ZoneId.of("Europe/London")));

		BiFunction<String, String, String> concatFunction = (s,t) -> s+t;
		System.out.println(concatFunction.apply("Hello ", "World"));

		concatFunction = FirstClassCitizenVariable::concatStrings;
		System.out.println(concatFunction.apply("Shipra ", "Chauhan"));

		FirstClassCitizenVariable instance = new FirstClassCitizenVariable();
		concatFunction = instance::concatString;
		System.out.println(concatFunction.apply("Instance ", "Used"));


		System.out.println(concatTransform("Hello ", "World", s->s.toUpperCase()));

		Function<String, String> transformToLower = s->s.toLowerCase();
		System.out.println(concatTransform("Shipra ", "Chauhan", transformToLower));

		Supplier<String> xFormOps = createCombinedandTransform("Combined ", "FUnction", a->a.toUpperCase());
		System.out.println(xFormOps.get());
	}

	private static String concatStrings(String a, String b) {
		return a + b;
	}

	String concatString(String a, String b) {
		return a + b;
	}

	private static String concatTransform(String a, String b, Function<String, String> stringTransform) {
		if (stringTransform != null) {
			a = stringTransform.apply(a);
			b = stringTransform.apply(b);
		}
		return a + b;
		
	}

	private static Supplier<String> createCombinedandTransform( final String a,
			final String b,
			final Function<String, String> transformer) {
		return () -> {
			String aa = a;
			String bb = b;
			if(transformer != null) {
				aa = transformer.apply(a);
				bb = transformer.apply(b);
			}
			return aa + bb;
		};
	}
	

}
