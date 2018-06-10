package algo.questions;

import java.util.Scanner;

public class FindCountOfSubarraysWithSumLessThanK {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		while (t-- > 0) {
			String[] sizeTarget = sc.nextLine().split(" ");
			int size = Integer.parseInt(sizeTarget[0]);
			int target = Integer.parseInt(sizeTarget[1]);
			String[] inputArr = sc.nextLine().split(" ");
			int countSubArrays = findCountOfSubarraysWithSumLessThanK(inputArr, size, target);
			System.out.println(countSubArrays);
		}
	}

	private static int findCountOfSubarraysWithSumLessThanK(String[] arr, int size, int target) {
		int i = 0;
		int j = 0;
		int sum = 0;
		int count = 0;
		while (i < size) {
			sum = sum + Integer.parseInt(arr[i]);
			while (sum >= target && j < size) {
				sum = sum - Integer.parseInt(arr[j]);
				j++;
			}
			if (sum < target) {
				count = count + 1 + (i - j);
			}
			i++;
		}
		return count;
	}
}
