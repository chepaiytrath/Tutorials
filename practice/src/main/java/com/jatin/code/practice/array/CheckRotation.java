package com.jatin.code.practice.array;

public class CheckRotation {
	public static void main(String[] args) {
		String s1 = new String("apple");
		String s2 = new String("pleap");

		boolean result = isRotationEasy(s1, s2);
		System.out.println(result);
	}

	private static boolean isRotation(String s1, String s2) {
		if(s1.length() != s2.length()) {
			return false;
		}
		String temp = new String();
		for(int i = 0; i<s1.length(); i++) {
			if(!isSubstring(s2, s1.substring(i))) {
				temp = temp+s1.charAt(i);
			}else {
				s1=s1.substring(i) + temp;
				break;
			}
		}
		return s1.equals(s2);
	}

	private static boolean isRotationEasy(String s1, String s2) {
		if(s1.length() != s2.length()) {
			return false;
		}
		String s1s1 = s1 + s1;
		return isSubstring(s1s1, s2);
	}
	
	public static boolean isSubstring(String parent, String child) {
		return parent.contains(child);
	}
}
