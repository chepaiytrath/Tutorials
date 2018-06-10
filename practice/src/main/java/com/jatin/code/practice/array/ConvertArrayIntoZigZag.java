package com.jatin.code.practice.array;

import java.util.Arrays;
import java.util.Scanner;

public class ConvertArrayIntoZigZag {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int size = sc.nextInt();
			int[] arr = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = sc.nextInt();
			}
			for(int x : convertArrayIntoZigZag(arr, size) ) {
				System.out.print(x+" ");
			}
			System.out.println();
		}
	}

	private static int[] convertArrayIntoZigZag(int[] arr, int size) {
		boolean flag = true; // < expected
		int temp = 0;
		for(int i = 0; i < size-1; i++) {
			if(flag) {
				if(arr[i] > arr[i+1]) {
					temp = arr[i+1];
					arr[i+1] = arr[i];
					arr[i] = temp;
				}
			}else {
				if(arr[i] < arr[i+1]) {
					temp = arr[i+1];
					arr[i+1] = arr[i];
					arr[i] = temp;
				}
			}
			flag = !flag;
		}
		return arr;
	}
}
