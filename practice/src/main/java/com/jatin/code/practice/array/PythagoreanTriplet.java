package com.jatin.code.practice.array;

import java.util.Arrays;
import java.util.Scanner;

public class PythagoreanTriplet {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int size = sc.nextInt();
			int[] arr = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println(findIfPythagoreanTripletExsists(arr, size));
		}
	}

	private static String findIfPythagoreanTripletExsists(int[] arr, int size) {
		for (int i = 0; i < size; i++) {
			arr[i] = (int) Math.pow(arr[i], 2);
		}
		Arrays.sort(arr);
		for (int i = size - 1; i >= 0; i--) {
			int j = 0;
			int k = i - 1;

			while (j < k) {
				if (arr[j] + arr[k] == arr[i]) {
					return "Yes";
				}
				if (arr[j] + arr[k] < arr[i]) {
					j++;
				} else {
					k--;
				}
			}
		}
		return "No";
	}
}
