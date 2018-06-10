package com.jatin.code.practice.array;

import java.util.Arrays;
import java.util.Scanner;

public class ChcolateDistriution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int size = sc.nextInt();
			int[] arr = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = sc.nextInt();
			}
			int m = sc.nextInt();
			System.out.println(findChocolateDistribuion(arr, size, m));
		}
	}

	private static int findChocolateDistribuion(int[] arr, int size, int m) {
		Arrays.sort(arr);
		int i = 0;
		int minDiff = Integer.MAX_VALUE;
		while (i <= size - m) {
			minDiff = Math.min(arr[i+ m-1] - arr[i], minDiff);
			i++;
		}
		return minDiff;
	}
}
