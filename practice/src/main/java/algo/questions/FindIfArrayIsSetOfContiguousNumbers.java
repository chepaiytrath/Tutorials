package algo.questions;

import java.util.Arrays;
import java.util.Scanner;

public class FindIfArrayIsSetOfContiguousNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int size = sc.nextInt();
			int[] arr = new int[size];
			int n = 0;
			while(n < size) {
				arr[n] = sc.nextInt();
				n++;
			}
			String isValid = findIfArrayIsSetOfContiguousNumbers2(arr, size);
			System.out.println(isValid);
		}
	}

	private static String findIfArrayIsSetOfContiguousNumbers(int[] arr, int size) {
		String isValid = "Yes";
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		Arrays.sort(arr);
		int x = arr[arr.length - 1];
		int[] arrCount = new int[x+1];
		int i = 0;
		while(i < arr.length) {
			int val = arr[i];
			if(val > max) max = val;
			if(val < min) min = val;
			arrCount[val] = 1;
			i++;
		}
		
		while(min <= max) {
			if(arrCount[min] == 0) {
				isValid = "No";
			}
			min++;
		}
		return isValid;
	}
	
	private static String findIfArrayIsSetOfContiguousNumbers2(int[] arr, int size) {
		Arrays.sort(arr);
		int i = 0;
		while(i < size - 1) {
			if(arr[i+1] > arr[i] + 1) {
				return "No";
			}
			i++;
		}
		return "Yes";
	}
}
