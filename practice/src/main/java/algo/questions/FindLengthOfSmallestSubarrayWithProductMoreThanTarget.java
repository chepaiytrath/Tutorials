package algo.questions;

import java.util.Scanner;

public class FindLengthOfSmallestSubarrayWithProductMoreThanTarget {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		while (t-- > 0) {
			String[] sizeTarget = sc.nextLine().split(" ");
			int size = Integer.parseInt(sizeTarget[0]);
			int target = Integer.parseInt(sizeTarget[1]);
			String[] arr = sc.nextLine().split(" ");

			System.out.println(findLengthOfSmallestSubarrayWithProductMoreThanTarget2(arr, size, target));
		}
	}

	private static int findLengthOfSmallestSubarrayWithProductMoreThanTarget(String[] arr, int size, int target) {
		int i = 0;
		int j = 0;
		int prod = 1;
		int minLength = Integer.MAX_VALUE;
		while (i < size) {
			prod = prod * Integer.parseInt(arr[i]);

			while (prod >= target) {
				if (minLength > 1 + (i - j)) {
					minLength = 1 + (i - j);
				}
				prod = prod / Integer.parseInt(arr[j]);
				j++;
			}
			i++;
		}
		return minLength;
	}

	private static int findLengthOfSmallestSubarrayWithProductMoreThanTarget2(String[] arr, int size, int target) {
		int i = 0; int j = 0; int prod = 1; int minLength = Integer.MAX_VALUE;
		while (i < size) {
			while (prod < target && i < size) {
				prod = prod * Integer.parseInt(arr[i]);
				i++;
			}

			while (prod >= target && j < size) {
				if (minLength > (i - j)) {
					minLength = i - j;
				}
				prod = prod / Integer.parseInt(arr[j]);
				j++;
			}
		}
		return minLength;
	}
}
