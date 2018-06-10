package algo.questions;

import java.io.IOException;
import java.util.Scanner;

public class FindKthCharacterAfterNiterationsInBinaryString {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int m = 0;
			int k = 0;
			int n = 0;
			m = sc.nextInt();
			k = sc.nextInt();
			n = sc.nextInt();

			String binaryNum = findBinaryAfterIteration(m,n);
			System.out.println(binaryNum.charAt(k));
		}
	}

	private static String findBinaryAfterIteration(int m, int n) {
		String binaryNum = findBinary(m);
		int i = 1;
		while(i <= n) {
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < binaryNum.length(); j++) {
				sb.append(binaryNum.charAt(j) == '0' ? "01" : "10");
			}
			binaryNum = sb.toString();
			i++;
		}
		return binaryNum;
	}

	private static String findBinary(int num) {
		StringBuffer sb = new StringBuffer();
		while(num >= 1) {
			sb.append(num % 2);
			num = num/2;
		}
		return sb.reverse().toString();
	}

}
