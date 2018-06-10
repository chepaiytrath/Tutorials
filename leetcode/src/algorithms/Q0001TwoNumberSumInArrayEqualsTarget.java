package algorithms;

import java.util.HashMap;
import java.util.Map;

public class Q0001TwoNumberSumInArrayEqualsTarget {
	public static void main(String[] args) {
		int[] arr = new int[] { 4, 3, 3 };
		int target = 7;
		int[] result = twoSum2(arr, target);
		for (int x : result)
			System.out.println(x);
	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				return new int[] { map.get(target - nums[i]), i };
			} else {
				map.put(nums[i], i);
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	public static int[] twoSum2(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement) && map.get(complement) != i) {
				return new int[] { i, map.get(complement) };
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

}
