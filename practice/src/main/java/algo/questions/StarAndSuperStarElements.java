package algo.questions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StarAndSuperStarElements {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		while (t-- > 0) {
			int size = Integer.parseInt(sc.nextLine());
			String[] inputArr = sc.nextLine().trim().split("\\s+");
			int[] arr = new int[size];
			for (int j = 0; j < size; ++j) {
				arr[j] = Integer.parseInt(inputArr[j]);
            }
			findStarAndSuperStarElements(arr);
		}
	}

	private static void findStarAndSuperStarElements(int[] inputArr) {
		int max = Integer.MIN_VALUE;
		List<Integer> starElements = new ArrayList<Integer>();
		Integer superStarElement = null;
		
		int index = inputArr.length - 1;
		while (index >= 0) {
			if (inputArr[index] > max) {
				max = inputArr[index];
				starElements.add(max);
				superStarElement = max;
			} else if (inputArr[index] == max) {
				superStarElement = null;
			}
			index--;
		}

		for(int i = starElements.size() - 1; i >= 0; i--) {
			System.out.print(starElements.get(i));
			System.out.print(" ");
		}
		System.out.println();
		
		System.out.println(superStarElement == null ? -1 : superStarElement);
	}

}
