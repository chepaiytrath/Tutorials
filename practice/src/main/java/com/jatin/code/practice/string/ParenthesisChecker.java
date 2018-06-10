package com.jatin.code.practice.string;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class ParenthesisChecker {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.next());
		while (T-- > 0) {
			String str = sc.next();
			boolean isBalanced = findIfBalanced(str);
			System.out.println(isBalanced ? "balanced" : "not balanced");
		}
	}

	private static boolean findIfBalanced(String str) {
		List<Character> openingBracesList = Arrays.asList('{', '(', '[');
		List<Character> closingBracesList = Arrays.asList('}', ')', ']');
		if(closingBracesList.contains(str.charAt(0))) {
			return false;
		}
		
		Stack<Character> stack = new Stack<Character>();
		Map<Character, Character> oppositeCharMap = new HashMap<Character, Character>();
		oppositeCharMap.put('{', '}');
		oppositeCharMap.put('(', ')');
		oppositeCharMap.put('[', ']');

		for (int i = 0; i < str.length(); i++) {
			Character iChar = str.charAt(i);
			if (openingBracesList.contains(iChar)) {
				stack.push(iChar);
			} else if (closingBracesList.contains(iChar)) {
				try {
					Character stackTopChar = stack.pop();
					if(iChar != oppositeCharMap.get(stackTopChar)) {
						return false;
					}
				}catch(EmptyStackException e){
                    return false;
                }
			}
		}
		
		if(!stack.isEmpty()) {
			return false;
		}else {
			return true;
		}
	}
}
