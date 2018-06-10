package algo.questions;

import java.util.Scanner;
import com.google.common.base.Stopwatch;

public class FindIfCommonSubsequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		while (t-- > 0) {
			String[] input = sc.nextLine().split("\\s+");
			System.out.println(haveCommonSubsequence(input[0], input[1]) ? "1" : "0");
		}
	}

	private static boolean haveCommonSubsequence(String string1, String string2) {
		int i = 0;
		while(i < string1.length()) {
			if(string2.indexOf(string1.charAt(i)) >= 0) {
				return true;
			}
			i++;
		}
		return false;
	}
}
