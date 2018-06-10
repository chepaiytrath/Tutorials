package algo.questions;

import java.util.Scanner;

public class FindOverlappingRectangle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		while (t-- > 0) {
			String arr1[] = sc.nextLine().split(" ");
			String arr2[] = sc.nextLine().split(" ");

			int isOverlap = findIfOverlappingRectangle(arr1, arr2);
			System.out.println(isOverlap);
		}
	}

	private static int findIfOverlappingRectangle(String[] arr1, String[] arr2) {
		int x1 = Integer.parseInt(arr1[0]);
		int y1 = Integer.parseInt(arr1[1]);
		int x2 = Integer.parseInt(arr1[2]);
		int y2 = Integer.parseInt(arr1[3]);

		int a1 = Integer.parseInt(arr2[0]);
		int b1 = Integer.parseInt(arr2[1]);
		int a2 = Integer.parseInt(arr2[2]);
		int b2 = Integer.parseInt(arr2[3]);
		
		if(a1>x2 || a2<x1 || b2>y1 || b1<y2) {
			return 0;
		}
		return 1;
	}
}
