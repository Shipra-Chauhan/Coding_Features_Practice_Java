package com.practice.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class CryptoAnagram {

	// Complete the makeAnagram function below.
	static int makeAnagram(String a, String b) {
		char ca, cb;
		LinkedHashMap<Character, Integer> mapA = new LinkedHashMap<Character, Integer>();
		LinkedHashMap<Character, Integer> mapB = new LinkedHashMap<Character, Integer>();
		for (char c = 'a'; c <= 'z'; c++) {
			mapA.put(c, 0);
			mapB.put(c, 0);
		}
		for (int i = 0; i < a.length(); i++) {
			ca = a.charAt(i);
			mapA.put(ca, mapA.get(ca) + 1);
		}
		for (int i = 0; i < b.length(); i++) {
			cb = b.charAt(i);
			mapB.put(cb, mapB.get(cb) + 1);
		}
		int sum = 0;
		System.out.println(mapA.size());
		for (char c1 = 'a'; c1 <= 'z'; c1++) {
			System.out.println("b Map A = " + mapA.get(c1) + " Map B = "
					+ mapB.get(c1));
			if (mapA.get(c1) > mapB.get(c1)) {
				System.out.println("Map A = " + mapA.get(c1) + " Map B = "
						+ mapB.get(c1));
				sum = sum + (mapA.get(c1) - mapB.get(c1));
			} else if (mapA.get(c1) < mapB.get(c1)) {
				sum = sum + (mapB.get(c1) - mapA.get(c1));
			}

		}
		return sum;
	}

	public static void main(String[] args) throws IOException {
		/*
		 * BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
		 * System.getenv("OUTPUT_PATH")));
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();

		String b = br.readLine();

		int res = makeAnagram(a, b);

		System.out.println(res);
	}
}
