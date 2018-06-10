package algo.questions;

import java.util.Scanner;

public class FindSumOfNumbersFormedBy456 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		while (t-- > 0) {
			String[] arr = sc.nextLine().split(" ");
			long sum = findSumOfCombinations(arr);
			System.out.println(sum);
		}
	}

	private static long findSumOfCombinations(String[] arr) {
		int mod = 1000000007;

		int x4 = Integer.valueOf(arr[0]);
		int y5 = Integer.valueOf(arr[1]);
		int z6 = Integer.valueOf(arr[2]);

		long sum[][][] = new long[x4+1][y5+1][z6+1];
		long count[][][] = new long[x4+1][y5+1][z6+1];
		count[0][0][0] = 1;
		
		long result = 0;

		for (int i = 0; i <= x4; i++) {
			for (int j = 0; j <= y5; j++) {
				for (int k = 0; k <= z6; k++) {
					if (k != 0) {
						sum[i][j][k] += ((sum[i][j][k-1] * 10) + (6 * count[i][j][k-1])) % mod;
						sum[i][j][k] = sum[i][j][k] % mod;
						
						count[i][j][k] += (count[i][j][k-1]);
						count[i][j][k] = count[i][j][k] % mod;
					}
					if (j != 0) {
						sum[i][j][k] += ((sum[i][j-1][k] * 10) + (5 * count[i][j-1][k])) % mod;
						sum[i][j][k] = sum[i][j][k] % mod;
						
						count[i][j][k] += (count[i][j-1][k]);
						count[i][j][k] = count[i][j][k] % mod;
					}
					if (i != 0) {
						sum[i][j][k] += ((sum[i-1][j][k] * 10) + (4 * count[i-1][j][k])) % mod;
						sum[i][j][k] = sum[i][j][k] % mod;
						
						count[i][j][k] += (count[i-1][j][k]);
						count[i][j][k] = count[i][j][k] % mod;
					}

					result += sum[i][j][k];
					result %= mod;
				}
			}
		}

		return result;
	}
}
