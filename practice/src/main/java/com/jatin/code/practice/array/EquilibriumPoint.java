package com.jatin.code.practice.array;

import java.util.Scanner;

public class EquilibriumPoint {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int size = sc.nextInt();
			int[] arr = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = sc.nextInt();
			}
			int i  = calculateEquilibriumPoint2(arr, size);
			System.out.println(i);
		}
	}
	private static int calculateEquilibriumPoint2(int[] arr, int size) {
		int sum = 0;
		for(int i = 0; i < size; i++) {
			sum += arr[i];
		}
		int leftsum = 0;
		for(int i = 0; i < size; i ++) {
			sum -= arr[i];
			if(leftsum == sum) {
				return i + 1;
			}
			leftsum += arr[i];
		}
		return -1;
	}
	
	private static int calculateEquilibriumPoint(int[] arr, int size) {
		int index = -1;
		int start = 0;
		int end = arr.length - 1;
		int curr = size / 2;
		int leftSum = 0;
		int rightSum = 0;
		
		while(start < curr && start >=0) {
			leftSum += arr[start++];
		}
		while(end > curr && end < size) {
			rightSum += arr[end--];
		}
		if(leftSum < rightSum) {
			while(curr < size) {
				int val= arr[curr++];
				leftSum += val;
				if(curr < size) {
					rightSum -= arr[curr];
				}
				if(leftSum == rightSum) {
					return curr+1;
				}
			}
		}else if(leftSum > rightSum){
			while(curr >= 0) {
				int val= arr[curr--];
				leftSum -= val;
				if(curr >= 0) {
					rightSum += arr[curr];
				}
				if(leftSum == rightSum) {
					return curr+1;
				}
			}
		}else {
			return curr;
		}
		return index;
	}
}
