package com.jatin.code.practice.goldmansachs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindFirstNonRepeatingChar {
	public static void main(String[] args) {
		String input = "abcxyzabc";
		Character output = findFirstNonRepeatingChar3(input);
		System.out.println(output);
	}
	public static char findFirstNonRepeatingChar1(String input) {
		// TIME COMPLEXITY : O(n2)
		List<Character> charList = input.chars().mapToObj(e->(char)e)
				.collect(Collectors.toList());
		for(int i = 0; i < charList.size(); i++) {
			Character x = charList.get(i);
			boolean foundX = false;
			for(int j = i+1; j < charList.size(); j++) {
				Character y = charList.get(j);
				if(x.equals(y)) {
					charList.remove(j);
					foundX = true;
				}
			}
			if(!foundX) {
				return x.charValue();
			}
		}
		return '0';
	}
	
	public static char findFirstNonRepeatingChar2(String input) {
		// TIME COMPLEXITY : O(n)
		char[] charCountArr = new char[256];
		for(int i = 0; i < input.length(); i++) {
			charCountArr[input.charAt(i)]++;
		}
		int index = 0;
		for(int i = 0; i < input.length(); i++) {
			if(charCountArr[input.charAt(i)] == 1) {
				index = i;
				break;
			}
		}
		return input.charAt(index);
	}
		
	public static Character findFirstNonRepeatingChar3(String input) {
		Map<Character, CountIndex> countMap = new HashMap<Character, CountIndex>();
		for(int i = 0; i < input.length(); i++) {
			if(!countMap.containsKey(input.charAt(i))) {
				countMap.put(input.charAt(i), new CountIndex(i));
			}else {
				countMap.get(input.charAt(i)).incCount();
			}
		}
		
		int index = Integer.MAX_VALUE;
		for(Character ch : countMap.keySet()) {
			if(countMap.get(ch).getCount() == 1 && index > countMap.get(ch).getIndex()) {
				index = countMap.get(ch).getIndex();
			}
		}
		
		return index==Integer.MAX_VALUE ? null : input.charAt(index);
	}
	
	static class CountIndex{
		int count;
		int index;
		
		public CountIndex(int index) {
			super();
			this.count = 1;
			this.index = index;
		}
		
		public void incCount() {
			this.count++;
		}

		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
	}
}
