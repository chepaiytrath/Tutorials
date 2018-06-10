package algo.questions;

import java.io.IOException;
import java.util.Scanner;

public class PrimeNumberOfSetBits {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int i = 0;
			int l = 0;
			int r = 0;
			l = sc.nextInt();
			r = sc.nextInt();
			int countPrimeSetBits = findCountSetBits(l, r);
			System.out.println(countPrimeSetBits);
		}
	}

	private static int findCountSetBits(int l, int r) {
		int count = 0;
		for (int i = l; i <= r; i++) {
			if (prime(numberOfSetBits(i))) {
				count++;
			}
		}
		return count;
	}

	private static int numberOfSetBits(int i) {
		int count = 0;
		while (i >= 1) {
			if (i % 2 == 1) {
				count++;
			}
			i = i / 2;
		}
		return count;
	}

	private static boolean prime(int num) {
		if (num == 0 || num == 1) {
			return false;
		} else {
			for (int i = 2; i <= num / 2; i++) {
				if (num % i == 0) {
					return false;
				}
			}
		}
		return true;
	}

}
