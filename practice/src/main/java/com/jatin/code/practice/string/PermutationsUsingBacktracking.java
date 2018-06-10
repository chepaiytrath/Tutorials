package com.jatin.code.practice.string;

import java.util.Scanner;

public class PermutationsUsingBacktracking {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			String str = sc.nextLine();
			//permute(str, 0, str.length()-1);
			permute2("", str);
		}
	}

	private static void permute(String str, int start, int end) {
		if(start == end) {
			System.out.println(str);
			return;
		}else {
			for(int i = start; i <= end; i++) {
				str = swap(str, start, i);
				permute(str, start+1, end);
				str = swap(str, start, i);
			}
		}
	}

	private static String swap(String str, int i, int j) {
		char temp;
        char[] charArray = str.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
	}
	
	private static void permute2(String chosen, String rem) {
		if(rem.length() == 0) {
			System.out.print(chosen+" ");
			return;
		}
		for(int i = 0; i < rem.length(); i++) {
			permute2(chosen+rem.charAt(i), rem.substring(0, i)+rem.substring(i+1));
		}
	}
}
