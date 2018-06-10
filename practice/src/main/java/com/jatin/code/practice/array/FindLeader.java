package com.jatin.code.practice.array;

import java.util.Scanner;
import java.util.Stack;

public class FindLeader {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int size = sc.nextInt();
			int arr[] = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = sc.nextInt();
			}
			printLeaders(arr, size);
		}
	}

	private static void printLeaders(int[] arr, int size) {
		Stack<Integer> stack = new Stack<Integer>();
		int i = size-1;
		stack.push(arr[i]);
		while(i >= 0) {
			if(arr[i] > stack.peek()) {
				stack.push(arr[i]);
			}
			i--;
		}
		int x = 0;
		while(x < stack.size()) {
			System.out.print(stack.pop()+" ");
		}
		System.out.println();
	}
}
