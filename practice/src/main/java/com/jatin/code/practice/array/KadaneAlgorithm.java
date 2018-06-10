package com.jatin.code.practice.array;

import java.util.Scanner;

public class KadaneAlgorithm {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0) {
			int s = sc.nextInt();
			int[] arr = new int[s];
			for (int i = 0; i < s; i++) {
				arr[i] = sc.nextInt();
			}
			long x = findMaxSumOfContigousSubArray(arr);
			System.out.println(x);
		}
	}

	private static long findMaxSumOfContigousSubArray(int[] arr) {
		int i = 0;
		int sum = 0;
		long maxSum = Long.MIN_VALUE;
		while (i < arr.length) {
			sum = sum + arr[i];
			maxSum = Math.max(sum, maxSum);
			if (sum < 0) {
				sum = 0;
			}
			i++;
		}
		return maxSum;
	}

}
