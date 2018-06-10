package com.jatin.code.practice.array;

import java.util.Scanner;

public class TrappingRainWater {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int size = sc.nextInt();
			int[] arr = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println(findTrappedRainWater(arr, size));
		}
	}

	// Rain units above current tower = Min(Val of max tower to left, val of max tower to right) - val of current tower
	// For a tower to be eligible to store rain units above itself, it should have larger towers than itself 
	// both at LHS and RHS anywhere.
	private static int findTrappedRainWater(int[] arr, int size) {
		int trappedRain = 0;
		int[] rightMaxArr = new int[size];
		int rightMax = 0;
		for (int i = size - 1; i >= 0; i--) {
			rightMaxArr[i] = rightMax;
			rightMax = Math.max(rightMax, arr[i]);
		}
		int leftMax = 0;
		for (int i = 0; i < size; i++) {
			if (arr[i] < leftMax && arr[i] < rightMaxArr[i]) {
				trappedRain += Math.min(leftMax, rightMaxArr[i]) - arr[i];
			}
			leftMax = Math.max(leftMax, arr[i]);
		}
		return trappedRain;
	}
}
