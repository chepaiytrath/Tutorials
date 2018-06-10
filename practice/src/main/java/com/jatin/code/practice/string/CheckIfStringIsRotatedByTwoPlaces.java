package com.jatin.code.practice.string;

import java.util.Scanner;

public class CheckIfStringIsRotatedByTwoPlaces {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());

		while(t-- > 0) {
			String x = sc.nextLine();
			String y = sc.nextLine();
			
			System.out.println(checkIfRotatedTwice(x, y) ? 1 : 0);
		}
	}

	private static boolean checkIfRotatedTwice(String x, String y) {
		String clockwise = x.substring(2) + x.substring(0, 2);
		String anticlockwise = x.substring(x.length() - 2) + x.substring(0, x.length() - 2);
		
		boolean clock = clockwise.equals(y);
		boolean anticlock = anticlockwise.equals(y);
		
		return clock||anticlock;
	}
}
