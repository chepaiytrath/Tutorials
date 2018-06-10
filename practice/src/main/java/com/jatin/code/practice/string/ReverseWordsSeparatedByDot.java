package com.jatin.code.practice.string;

import java.util.Scanner;

public class ReverseWordsSeparatedByDot {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		while (t-- > 0) {
			String[] arr = sc.nextLine().split("\\.");
			System.out.println(printWordsInReverse(arr, arr.length));
		}
	}

	private static String printWordsInReverse(String[] arr, int length) {
		StringBuffer sb = new StringBuffer();
		for(int i = length-1; i >= 0; i--) {
			if(i == 0) {
				sb.append(arr[i]);
			}else {
				sb.append(arr[i]);
				sb.append(".");	
			}
		}
		return sb.toString();
	}
}
