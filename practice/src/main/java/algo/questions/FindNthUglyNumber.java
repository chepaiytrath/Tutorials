package algo.questions;

import java.util.Scanner;

public class FindNthUglyNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());

		while (t-- > 0) {
			int n = Integer.parseInt(sc.nextLine());
			long uglyNum = findNthUglyNum(n);
			System.out.println(uglyNum);
		}
	}

	private static long findNthUglyNum(int n) {
		int count = 1;
		long i = 1;
		while(count < n) {
			i++;
			if(isUgly(i)) {
				count++;
			}
		}
		return i;
	}

	private static boolean isUgly(long i) {
		i = maxDivide(i,2);
		i = maxDivide(i,3);
		i = maxDivide(i,5);
		return i == 1 ? true : false;
	}

	private static long maxDivide(long i, int j) {
		while(i % j == 0) {
			i = i / j;
		}
		return i;
	}
}
