package com.jatin.code.practice.goldmansachs;

public class UglyNumber {
	/* Driver program to test above functions */
	public static void main(String args[]) {
		int n = 11;
		int no = getNthUglyNo(n);
		System.out.println(n+"th ugly no. is " + no);
	}

	private static int getNthUglyNo(int n) {
		int count = 1;
		int i = 1;
		while(count < n) {
			i++;
			if(isUgly(i)) {
				count++;
			}
		}
		return i;
	}

	private static boolean isUgly(int i) {
		i = maxDivide(i,2);
		i = maxDivide(i,3);
		i = maxDivide(i,5);
		return (i == 1) ? true : false;
	}

	private static int maxDivide(int i, int j) {
		while(i % j == 0) {
			i = i / j;
		}
		return i;
	}
}
