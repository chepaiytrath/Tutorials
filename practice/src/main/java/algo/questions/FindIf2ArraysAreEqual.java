package algo.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindIf2ArraysAreEqual {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());

		while (t-- > 0) {
			int size = Integer.parseInt(sc.nextLine());
			String arr1[] = sc.nextLine().split(" ");
			String arr2[] = sc.nextLine().split(" ");

			int equal = checkEqualityOfArrays(arr1, arr2, size);
			System.out.println(equal);
		}
	}

	private static int checkEqualityOfArrays(String[] arr1, String[] arr2, int size) {
		if (arr1.length != arr2.length) {
			return 0;
		}
		int i = 0; int key = 0;
		Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		while (i < arr1.length) {
			key = Integer.parseInt(arr1[i]);
			if (!map1.containsKey(key)) {
				map1.put(key, 1);
			} else {
				map1.put(key, map1.get(key) + 1);
			}
			i++;
		}
		i = 0;
		while (i < arr2.length) {
			key = Integer.parseInt(arr2[i]);
			if (!map1.containsKey(key)) {
				return 0;
			} else if (map1.get(key) == 1) {
				map1.remove(key);
			}else {
				map1.put(key, map1.get(key) - 1);
			}
			i++;
		}
		if(map1.isEmpty()) {
			return 1;
		}
		return 0;
	}
}
