package algo.questions;

import java.util.Scanner;

public class FindMaxHeightOfStaircase {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int noOfTestCases = reader.nextInt();
		int i = 0;
		int[] arr = new int[noOfTestCases];
		while (i < noOfTestCases) {
			arr[i] = reader.nextInt();
			i++;
		}
		reader.close();
		
		i = 0;
		while(i < arr.length) {
			arr[i] = findHeightOfStaircase(arr[i]);
			i++;
		}
		
		printOutput(arr);
	}

	private static void printOutput(int[] arr) {
		for(int height : arr) {
			System.out.println(height);
		}
		
	}

	private static int findHeightOfStaircase(int n) {
		int heightPerBlock = 1;
		int i = 1;
		int height = 0;
		
		while(n>0) {
			n = n - (heightPerBlock * i);
			i++;
			height++;
		}
		if(n<0) {
			height = height - 1;
		}
		return height;
	}
}
