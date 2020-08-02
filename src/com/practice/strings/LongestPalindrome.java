package com.practice.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestPalindrome {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the string");
		String s = br.readLine();
		String[] str1 = new String[s.length()];
		int max = 0;
		String str = "";
		int j = 0, k = 0;
		char c, ch;
		for (int i = 0; i < s.length(); i++) {
			j = i + 1;
			ch = s.charAt(i);
			while (j < s.length()) {
				c = s.charAt(j);
				if (c == ch) {
					str = s.substring(i, j + 1);
					if (str.equals(reverse(str))) {

						str1[k] = str;
						System.out.println(str1[k]);
						k++;
						i = j;
					}
				}
				j++;
			}
		}

		for (int p = 0; p < str1.length; p++) {
			if(str1[p]!= null && (str1[p].length()>max)){
				max = str1[p].length();
				str = str1[p];
			}
		
		}
		System.out.println(" The  palindrome string = " + str);
	}

	private static String reverse(String s) {
		// TODO Auto-generated method stub

		String s1 = "";
		for (int l = s.length() - 1; l >= 0; l--)
			s1 = s1 + s.charAt(l);

		//System.out.println(s1);
		return s1;
	}

}
