package com.jatin.code.practice.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class MaxOfAllSubarraysOfSizeK {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int size = sc.nextInt();
			int k = sc.nextInt();
			int arr[] = new int[size];
			for(int i = 0; i<size; i++) {
				arr[i] = sc.nextInt();
			}
			printMaxOfAllSubArrays2(arr, size, k);
		}
	}

	private static void printMaxOfAllSubArrays2(int[] arr, int size, int k) {
		int i = 0; 
		List<Integer> list = new ArrayList<Integer>();
		while(i <= size - k) {
			int j = i;
			int max = arr[i];
			while(j <= i+k-1) {
				max = Math.max(max, arr[j]);
				j++;
			}
			list.add(max);
			i++;
		}
		for(int x : list) {
			System.out.print(x+" ");
		}
		System.out.println();
	}
}
