package algorithms;

public class Q0042TrappingRainWater {

	// FORMULA : FIND THE AMOUNT OF WATER EACH BLOCK CAN HOLD INDIVIDUALLY.

	public static void main(String[] args) {
		// int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int[] arr = { 0, 2, 0, 0, 0, 0, 0, 2, 0 };
		System.out.println(trap2(arr));
	}

	public static int trapONUsingDP(int[] arr) {
		if (arr == null)
			return 0;
		int ans = 0;
		int size = arr.length;
		// int[] left_max = new int[size];
		int[] right_max = new int[size];

		int max = Integer.MIN_VALUE;
		/*
		 * for (int i = 0; i < size; i++) { max = Math.max(max, arr[i]); left_max[i] =
		 * max; } max = Integer.MIN_VALUE;
		 */
		for (int i = size - 1; i >= 0; i--) {
			max = Math.max(max, arr[i]);
			right_max[i] = max;
		}
		int leftMax = Integer.MIN_VALUE;
		for (int i = 0; i < size; i++) {
			leftMax = Math.max(leftMax, arr[i]);
			ans += Math.min(leftMax, right_max[i]) - arr[i];
		}
		return ans;
	}

	public static int trapONUsing2Pointers(int[] arr) {
		int i = 0;
		int j = arr.length - 1;

		int trappedWater = 0;

		int leftMax = 0, rightMax = 0;
		while (i < j) {
			if (arr[i] < arr[j]) {
				if (arr[i] < leftMax) {
					trappedWater += leftMax - arr[i];
				} else {
					leftMax = arr[i];
				}
				i++;
			} else {
				if (arr[j] < rightMax) {
					trappedWater += rightMax - arr[j];
				} else {
					rightMax = arr[j];
				}
				j--;
			}
		}
		return trappedWater;
	}

	public static int trap1(int[] arr) {
		// DP
		int trapped = 0;
		int[] leftMax = new int[arr.length];
		int[] rightMax = new int[arr.length];

		int max = Integer.MIN_VALUE;
		/*
		 * for (int i = 0; i < arr.length; i++) { max = Math.max(max, arr[i]);
		 * leftMax[i] = max; } max = Integer.MIN_VALUE;
		 */
		for (int i = arr.length - 1; i >= 0; i--) {
			max = Math.max(max, arr[i]);
			rightMax[i] = max;
		}

		max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
			trapped += Math.min(max, rightMax[i]) - arr[i];
		}
		return trapped;
	}

	public static int trap2(int[] arr) {
		int i = 0, j = arr.length-1;
		int leftMax = 0, rightMax = 0, trapped = 0;
		while (i < j) {
			if (arr[i] < arr[j]) {
				if(arr[i] < leftMax) {
					trapped += leftMax -arr[i];
				}else {
					leftMax = arr[i];
				}
				i++;
			}
			else {
				if(arr[j] < rightMax) {
					trapped += rightMax - arr[j];
				}else {
					rightMax = arr[j];
				}
				j--;
			}
		}
		return trapped;
	}

}
