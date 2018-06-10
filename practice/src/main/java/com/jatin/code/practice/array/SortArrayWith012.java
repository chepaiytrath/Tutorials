package com.jatin.code.practice.array;

import java.util.Scanner;

public class SortArrayWith012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int s = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			printIndexOfSubArray(s, arr);
		}
	}

	private static void printIndexOfSubArray(int expected, int[] arr) {
		int start = 0, end = 0, sum = 0;
		boolean found = false;
		while(start < arr.length) {
			while(sum < expected && end < arr.length) {
				sum = sum + arr[end++];
			}
			if(sum < expected && end == arr.length) {
				break;
			}
			while(sum > expected) {
				sum = sum - arr[start++];
			}
			if(sum == expected) {
				found = true;
				break;
			}
		}
		if(found) {
			System.out.println((start+1)+" "+(end));
		}else {
			System.out.println("-1");
		}
		
	}
}
