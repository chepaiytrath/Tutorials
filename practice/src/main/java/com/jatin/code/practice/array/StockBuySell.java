package com.jatin.code.practice.array;

import java.util.Scanner;

public class StockBuySell {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int size = sc.nextInt();
			int[] arr = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = sc.nextInt();
			}
			printBuySellDays(arr, size);
		}
	}

	private static void printBuySellDays(int[] arr, int size) {
		int[] minima = new int[size / 2 + 1];
		int[] maxima = new int[size / 2 + 1];
		int i = 0;
		int count = 0;
		while (i < size - 1) {
			while (i < size - 1 && arr[i + 1] <= arr[i]) {
				i++;
			}
			if(i == size - 1) {
				break;
			}
			
			minima[count] = i;

			while (i < size - 1 && arr[i + 1] >= arr[i]) {
				i++;
			}
			maxima[count] = i;
			count++;
			i++;
		}
		
		i = 0;
		if(count > 0) {
			while (i < count) {
				System.out.print("(" + minima[i] + " " + maxima[i] + ") ");
				i++;
			}
			System.out.println();
		}else {
			System.out.println("No Profit");
		}
	}
}
