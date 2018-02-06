package com.jatin.code.practice.goldmansachs;

import java.util.Arrays;

public class SortArrayInWaveForm {
	public static void main(String[] args) {
		int arr[] = {10, 5, 6, 3, 2, 20, 100, 80};
		sortArrayInWaveForm2(arr);
		for (int i : arr)
            System.out.print(i + " ");
	}

	private static void sortArrayInWaveForm(int[] arr) {
		Arrays.sort(arr);
		int index = 0;
		int lastIndex = arr.length - 1;
		while(index < lastIndex) {
			swap(arr, index, index+1);
			index = index + 2;
		}
	}
	
	private static void sortArrayInWaveForm2(int[] arr) {
		// Time Complexity : O(n)
		int i = 0;
		int lastIndex = arr.length - 1;
		while(i < lastIndex) {
				if(i > 0 && arr[i] < arr[i-1]) {
					swap(arr, i, i-1);
				}
				if(i < lastIndex && arr[i] < arr[i+1])
				{
					swap(arr, i, i+1);
				}
				i = i + 2;
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
