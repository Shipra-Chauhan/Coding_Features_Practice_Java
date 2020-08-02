package com.practice.arrays;

public class ReverseArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ReverseArray obj = new ReverseArray();
		int[] a = {1,2,3,4,5,6,7,8,9,10};
		obj.reverseArr(a, a.length);
		obj.show(a, a.length);
	}

	void reverseArr(int[] a, int size){
		int temp = 0, j = size-1;
		for(int i = 0; i<size/2;i++){
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			j--;
		}
	}
	
	void show(int[] a, int size){
		for(int i = 0; i<size;i++){
			System.out.println(a[i]);
		}
	}
	
}
