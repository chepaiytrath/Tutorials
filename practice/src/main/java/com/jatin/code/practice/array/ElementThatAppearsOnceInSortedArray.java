package com.jatin.code.practice.array;

import java.util.Scanner;

public class ElementThatAppearsOnceInSortedArray {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int size = sc.nextInt();
			int[] arr = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = sc.nextInt();
			}
			//System.out.println(elementThatAppearsOnceInSortedArray(arr, size));
			System.out.println(elementThatAppearsOnceInSortedArrayUsingRecursion(arr, 0, size-1));
		}

	}

	private static int elementThatAppearsOnceInSortedArray(int[] arr, int size) {
		int i = 0;
		while(i < size-1) {
			if(arr[i]==arr[i+1]) {
				i = i + 2;
			}else {
				break;
			}
		}
		if(i > size - 1) {
			return -1;
		}
		return arr[i];
	}
	
	private static int elementThatAppearsOnceInSortedArrayUsingRecursion(int[] arr, int start, int end) {
		// odd : 2nd digit of pair   even : 1st digit of pair
		if(start > end) {
			return -1;
		}
		
		if(start == end) {
			return arr[start];
		}
		int mid = (start + end) / 2;
		
		if(mid % 2 == 0) {
			if(arr[mid] == arr[mid+1]) {
				return elementThatAppearsOnceInSortedArrayUsingRecursion(arr, mid+2, end);
			}else {
				return elementThatAppearsOnceInSortedArrayUsingRecursion(arr, start, mid);
			}
		}else {
			if(arr[mid] == arr[mid-1]) {
				return elementThatAppearsOnceInSortedArrayUsingRecursion(arr, mid+1, end);
			}else {
				return elementThatAppearsOnceInSortedArrayUsingRecursion(arr, start, mid);
			}
		}
	}
}
