package com.practice.dynamicprogramming;

import java.io.InputStreamReader;
import java.util.Scanner;

public class MinPowerNumber {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new InputStreamReader(System.in));
		System.out.println("Enter the number");
		int number = sc.nextInt();
		int power = number, min = Integer.MAX_VALUE;
double sq = Math.sqrt(number) - (int) Math.sqrt(number) == 0?Math.sqrt(number) : 0;
double cb = Math.cbrt(number) - (int)Math.cbrt(number)== 0? Math.cbrt(number) : 0;

if(sq!= 0 && cb!= 0) {
	min = 2;
}
else if(sq!=0) {
	min = 2;
}
else {
	min = 3;
}
		System.out.println("Output - " + min);
	}

}
