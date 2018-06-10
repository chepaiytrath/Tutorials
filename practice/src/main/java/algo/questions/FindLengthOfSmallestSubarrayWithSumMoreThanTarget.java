package algo.questions;

import java.util.Scanner;

public class FindLengthOfSmallestSubarrayWithSumMoreThanTarget {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		while (t-- > 0) {
			String[] sizeTarget = sc.nextLine().split(" ");
			int size = Integer.parseInt(sizeTarget[0]);
			int target = Integer.parseInt(sizeTarget[1]);
			String[] inputArr = sc.nextLine().split(" ");
			int lengthOfSmallestSubarray = findSubArraySize2(inputArr, size, target);
			System.out.println(lengthOfSmallestSubarray);
		}
	}

	private static int findSubArraySize2(String[] arr, int size, int target) {
		int lengthOfSmallestSubarray = size; int i = 0; int j = 0; int sum = 0;
		while(i < size) {
			while(sum < target && i < size) {
				sum += Integer.parseInt(arr[i]);
				i++;
			}
			while(sum >= target && j < size) {
				if(lengthOfSmallestSubarray > i - j) 
					lengthOfSmallestSubarray = i - j;
				sum -= Integer.parseInt(arr[j]);
				j++;
			}
		}
		return lengthOfSmallestSubarray;
	}
	
	
	private static int findSubArraySize(String[] arr, int size, int target) {
		int start = 0;
		int end = 0;
		int sum = 0;
		int minSubArraySize = size + 1;
		while (end < size) {
			while (sum <= target && end < size) {
				sum = sum + Integer.parseInt(arr[end++]);
			}
			while (sum > target && start < size) {
				if (minSubArraySize > end - start)
					minSubArraySize = end - start;
				sum = sum - Integer.parseInt(arr[start++]);
			}
		}
		return minSubArraySize;
	}
}
