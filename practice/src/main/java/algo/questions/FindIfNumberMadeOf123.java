package algo.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FindIfNumberMadeOf123 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		while(t-- > 0 ) {
			int arrSize = Integer.parseInt(sc.nextLine());
			String input = sc.nextLine();
			String[] arr = input.split(" ");
			processInputArray(arr);
		}
		sc.close();
	}

	private static void processInputArray(String[] arr) {
		int count = 0;
		List<Integer> output = new ArrayList<Integer>();
		for(String num : arr) {
			int x = Integer.parseInt(num);
			if(x != 0 && checkIfValid(x)) {
				count++;
				output.add(x);
			}
		}	
		if(count == 0) {
			System.out.println("-1");
		}else {
			Collections.sort(output);
			StringBuilder sb = new StringBuilder();
			for(Integer x : output) {
				sb.append(x.toString()).append(" ");
			}
			System.out.println(sb);
		}
	}

	private static boolean checkIfValid(int num) {
		while(num >  0) {
			int rem = num % 10;
			if(rem < 1 || rem >3) {
				return false;
			}
			num = num/10;
		}
		return true;
	}
}
