package com.jatin.code.practice.array;

import java.util.Scanner;

public class LeftSideSmallerRightSideGreater {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int size = sc.nextInt();
			int[] arr = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println(findLeftSideSmallerRightSideGreater(arr, size));
		}
	}

	private static int findLeftSideSmallerRightSideGreater(int[] arr, int size) {
		int[] minimumRightArr = new int[size];
		int minRight = Integer.MAX_VALUE;
		for (int i = size-1; i >= 0; i--) {
			minimumRightArr[i] = minRight;
			minRight = Math.min(arr[i], minRight);
		}
		int val = -1;
		int maxLeft = Integer.MIN_VALUE;
		for(int i = 0; i <= size-2; i++) {
			maxLeft = Math.max(maxLeft, arr[i]);
			if(i > 0 && maxLeft <= arr[i] && minimumRightArr[i] >= arr[i]) {
				val = arr[i];
				break;
			}
		}	
		return val;
	}
}
