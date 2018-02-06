package com.jatin.code.practice.array;

public class RotateMatrix {
	public static void main(String[] args) {
		int arr[][] = {{1, 2, 3}, {5, 6}, {9, 10, 11, 12}, {13}};
/*		arr[0] = new int[]{1, 2, 3};
		arr[1] = new int[]{5, 6};
		arr[2] = new int[]{9, 10, 11, 12};
		arr[3] = new int[]{13};
*/		//arr = rotate90Degrees(arr);
		for (int i = 0; i<arr.length; i++) {
			for (int j = 0; j<arr[i].length; j++) {
				System.out.println(arr[i][j]);
			}
		}
	}

	private static int[][] rotate90Degrees(int[][] arr) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
