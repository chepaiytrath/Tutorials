package com.jatin.code.practice.array;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		String str = "aaabbbccc";
		
		String removeDupes = usingHashSet(str);
		
		System.out.println(removeDupes);
	}
	static String usingHashSet(String str){
		if (null == str) { 
			return null; 
		}
		if(str.length() < 2) {
			return str;
		}
		Set<Character> set = new HashSet<Character>();
		String removeDupes = new String();
		for (int i = 0; i<str.length(); i++) {
			set.add(str.charAt(i));
		}
		for(Character s : set) {
			removeDupes = removeDupes + s;
		}
		return removeDupes;
	}
	
	static String usingBufferArray(String str) {
		if (null == str) { 
			return null; 
		}
		if(str.length() < 2) {
			return str;
		}
		char charArray[] = str.toCharArray();
		boolean buffer[] = new boolean[256];
		
		for (int i = 0; i < 256; i++) {
			buffer[i] = false;
		}
		
		int temp = 0;
		for(int j = 0; j < charArray.length; j++) {
			if(!buffer[charArray[j]]){
				charArray[temp] = charArray[j];
				temp++;
				buffer[charArray[j]] = true;
			}
		}
		charArray[temp] = 126;
		String x[] = String.valueOf(charArray).split("~");
		return x[0];
	}
}
