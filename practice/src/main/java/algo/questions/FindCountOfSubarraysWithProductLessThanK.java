package algo.questions;

import java.io.IOException;
import java.util.Scanner;

public class FindCountOfSubarraysWithProductLessThanK {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		while (t-- > 0) {
			String[] sizeTarget = sc.nextLine().split(" ");
			Long size = Long.parseLong(sizeTarget[0]);
			Long target = Long.parseLong(sizeTarget[1]);
			String[] inputArr = sc.nextLine().split(" ");
			int countSubArrays = findCountOfSubarraysWithProductLessThanK(inputArr, size, target);
			System.out.println(countSubArrays);
		}
	}

	private static int findCountOfSubarraysWithProductLessThanK(String[] arr, Long size, Long target) {
		int i = 0; int j = 0; Long prod = 1l; int count = 0;
		while(i < size) {
			prod = prod * Long.parseLong(arr[i]);
			while(prod > target && j < size) {
				prod /= Long.parseLong(arr[j++]);
			}
			if(prod < target) {
				count += 1 + (i - j);
			}
			i++;
		}
		return count;
	}
}
