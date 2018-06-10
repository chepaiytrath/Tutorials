package com.jatin.code.practice.array;

import java.util.Scanner;

//4x4
public class SpialMatrix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = 4;
			int arr[][] = new int[n][n];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					arr[i][j] = sc.nextInt();
			
			printSpiral(arr, 4, 4);
			System.out.println();
		}
	}

	private static void printSpiral(int[][] arr, int m, int n) {
		StringBuffer sb = new StringBuffer();
		int FR = 0, FC = 0;
		int LR = m-1, LC = n-1;
		
		while(FR <= LR && FC <= LC) {
			for(int i = FC; i <= LC; i++) {
				sb.append(arr[FR][i]+" ");
			}
			FR++;
			
			for(int i = FR; i <= LR; i++) {
				sb.append(arr[i][LC]+" ");
			}
			LC--;
			
			for(int i = LC; i >= FC; i--) {
				sb.append(arr[LR][i]+" ");
			}
			LR--;
			
			for(int i = LR; i >= FR; i--) {
				sb.append(arr[i][FC]+" ");
			}
			FC++;
		}
		
		System.out.print(sb.toString());
	}
}
