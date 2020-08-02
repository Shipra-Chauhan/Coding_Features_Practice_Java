package com.practice.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class ContiguousSubsequence {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the size of the array");
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		System.out.println("Enter the values of the array");
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		int sum = 0, maxsum = 0, j = 0;
		int[] b = new int[n];
		
		for(int i = 0 ; i< a.length ; i++){
			sum = sum + a[i];
		
			if(sum<maxsum){
				b[j] = a[i];
			}
			if(sum>maxsum){
				
				maxsum = sum;
			
			}
			else if (sum<0){
				sum = 0;
			}
			
		}
		
		for(int i = 0;i<n;i++){
			System.out.println("element " + b[i]);
		}
		System.out.println(" The maximum sum is - "+ maxsum);
	
		
	}

}
