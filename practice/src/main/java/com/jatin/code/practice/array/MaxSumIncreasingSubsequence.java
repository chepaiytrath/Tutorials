package com.jatin.code.practice.array;

import java.util.Scanner;

public class MaxSumIncreasingSubsequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int size = sc.nextInt();
			int[] arr = new int[size];
			
			for (int i = 0; i < size; i++) {
				arr[i] = sc.nextInt();
			}
			int i = findMaxSum(arr, size);
			System.out.println(i);
		}
	}

	private static int findMaxSum(int[] arr, int size) {
		int maxSum = -1;
		int[] maxArr = new int[size];
		for (int i = 0; i < size; i++) {
			maxArr[i] = arr[i];
			for (int j = 0; j < i; j++) {
				if(arr[i] > arr[j]) {
					maxArr[i] = Math.max(maxArr[i], maxArr[j]+arr[i]);
				}
			}
			maxSum = Math.max(maxArr[i], maxSum);
		}
		return maxSum;
	}
}
