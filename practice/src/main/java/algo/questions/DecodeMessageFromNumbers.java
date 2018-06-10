package algo.questions;

import java.util.Scanner;

public class DecodeMessageFromNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		while (t-- > 0) {
			int size = Integer.parseInt(sc.nextLine());
			String[] num = sc.nextLine().split("");
			int count = findCountOfPossibleCobos(num, size);
			System.out.println(count);
		}
	}

	private static int findCountOfPossibleCobos(String[] num, int size) {
		return 0;
	}
}
