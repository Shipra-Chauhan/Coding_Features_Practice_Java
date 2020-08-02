package com.practice.maps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.practice.pojo.Person;

class MergingMapsTest {

	@Test
	final void test() {
		MergingMaps mp = new MergingMaps();
		Map<Integer, List<Person>> map = new HashMap<>();
		map.put(26, Arrays.asList(new Person("Shipra", 26,  "F")));
		map.put(28, Arrays.asList(new Person("Rahul", 28, "M")));
	
	//	assertMapEquals(map, Arrays.asList(new Person("Shipra", 26,"F"), new Person("Rahul", 28, "M")));
	}

}
