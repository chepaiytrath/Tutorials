package com.jatin.code.practice.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class RomanToInteger {
	public static void main(String[] args) {
		/*Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);*/
		
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		while(t-- > 0) {
			String x = sc.nextLine();
			/*int[] arr = new int[x.length()];
			for(int i = 0; i < x.length(); i++) {
				arr[i] = map.get(x.charAt(i));
			}
			System.out.println(findIntegerOfRoman(arr));*/
			
			System.out.println(findIntegerOfRoman2(x));
		}
	}

	private static int findIntegerOfRoman(int[] arr) {
		Stack<Integer> s = new Stack<Integer>();
		for(int i = 0; i < arr.length; i++) {
			s.push(arr[i]);
		}
		int lastPopped = 0;
		int sum = 0;
		while(!s.isEmpty()) {
			int popped = s.pop();
			if(popped < lastPopped) {
				sum -= popped;
			}else {
				sum += popped;
			}
			lastPopped = popped;
		}
		return sum;
	}
	
	
	private static int findIntegerOfRoman2(String str) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		int i = str.length() - 1;
		int sum = map.get(str.charAt(i));
		while(i >= 1) {
			if(map.get(str.charAt(i-1)) < map.get(str.charAt(i))) {
				sum -= map.get(str.charAt(i-1));
			}else {
				sum += map.get(str.charAt(i-1));
			}
			i--;
		}
		return sum;
	}
}
