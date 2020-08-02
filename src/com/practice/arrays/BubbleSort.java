package com.practice.arrays;

import java.io.InputStreamReader;
import java.util.Scanner;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(new InputStreamReader(System.in));
		System.out.println("Enter the size of the array -");
		int size = sc.nextInt();
		int a[] = new int[size];
		/*
		 * int[] a2 = new int[a.length + 1]; System.arraycopy(a, 0, a2, 0, a.length);
		 * a2[a.length] = sc;
		 */
		System.out.println("Enter the elements of the array - ");
		for (int i = 0; i < size; i++) {
			a[i] = sc.nextInt();
		}
		bubbleSort(a, size);
		for (int i = 0; i < size; i++) {
			System.out.println(a[i]);
		}

	}

	private static void bubbleSort(int[] a, int size) {
		// TODO Auto-generated method stub
		int temp = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < a.length - i-1; j++) {
				if (a[j] > a[j+1]) {
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}

}
