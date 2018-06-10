package algo.questions;

import java.util.Scanner;

public class MergeTwoStrings {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		while(t-- > 0) {
			String[] input = sc.nextLine().split(" ");
			String first = input[0];
			String second = input[1];
			System.out.println(findMergedString(first, second));
		}
	}

	private static String findMergedString(String first, String second) {
		boolean firstLonger = first.length() > second.length();
		int len = firstLonger ? second.length() : first.length() ;
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while(i < len) {
			sb.append(first.charAt(i));
			sb.append(second.charAt(i));
			i++;
		}
		return firstLonger? sb.append(first.substring(i)).toString() : sb.append(second.substring(i)).toString();
	}
}
