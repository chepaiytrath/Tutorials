package com.jatin.code.practice.array;

import java.util.Scanner;

public class DutchNationalFlagProblem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int size = sc.nextInt();
			int[] arr = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = sc.nextInt();
			}
			arr = sortDutchNationalFlagProblem(arr, size);
			for(int x : arr) {
				System.out.print(x +" ");
			}
			System.out.println();
		}
	}

	private static int[] sortDutchNationalFlagProblem(int[] arr, int size) {
		int low = 0, high = size - 1, curr = 0;
		while (curr <= high) {
			switch (arr[curr]) {
				case 0: {
					swap(arr, low, curr);
					low++;
					curr++;
					break;
				}
				case 1: {
					curr++;
					break;
				}
				case 2: {
					swap(arr, high, curr);
					high--;
					break;
				}
			}
		}
		return arr;
	}

	private static void swap(int[] arr, int x, int y) {
		int temp = arr[y];
		arr[y] = arr[x];
		arr[x] = temp;
	}
}
