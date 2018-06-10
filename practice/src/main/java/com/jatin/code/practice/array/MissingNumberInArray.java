package com.jatin.code.practice.array;

import java.util.Scanner;

public class MissingNumberInArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0) {
			int n = sc.nextInt();
			long expectedSum = (n * (n+1))/2;
			long actualSum = 0;
			for (int i = 0; i < n-1; i++) {
				actualSum += sc.nextInt();
			}
			System.out.println(expectedSum - actualSum);
		}
	}
}
