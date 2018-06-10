package algo.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class FindPairsWithPositiveNegativeValues {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int size = sc.nextInt();
			int[] arr = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = sc.nextInt();
			}
			findPairs(arr, size);
			/*List<Integer> list = findPairs2(arr, size);
			if (!list.isEmpty()) {
				for (Integer i : list) {
					System.out.print(i + " ");
				}
			} else {
				System.out.print("0");
			}*/
			//System.out.println();

		}
	}

	private static void findPairs(int[] arr, int size) {
		Set<Integer> set = new HashSet<Integer>();
		int flag = 0;
		Arrays.sort(arr);
		for (int i = 0; i < size; i++) {
			int val = arr[i];
			if (!set.contains(-val)) {
				set.add(val);
			} else {
				System.out.print(String.valueOf(-val) + " " + String.valueOf(val) + " ");
				flag = 1;
			}
		}
		if (flag == 0) {
			System.out.print("0");
		}/*else {
			System.out.println();
		}*/
		
		
		System.out.println();
	}

	private static List<Integer> findPairs2(int[] arr, int size) {
		Set<Integer> negValSet = new HashSet<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(arr);
		int i = 0;
		while (i < size && arr[i] < 0) {
			negValSet.add(arr[i]);
			i++;
		}
		while (i < size) {
			int val = arr[i];
			//int negVal = val - (2 * val);
			if (negValSet.contains(-val)) {
				list.add(-val);
				list.add(val);
			}
			i++;
		}
		return list;
	}
}
