package com.jatin.code.practice.array;

import java.util.Arrays;

public class ReplaceSpacesWithHex {
	public static void main(String[] args) {
		String str = "I AM JATIN";
		str = usingArrayManipulation2(str.toCharArray(), str.length());
		System.out.println(str);
	}

	private static String usingSubString(String str) {
		if (null == str) {
			return null;
		}
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				str = str.substring(0, i) + "%20" + str.substring(i + 1);
				i = i + 2;
			}
		}
		return str;
	}

	public static String usingArrayManipulation1(char[] str, int length) {
		int spaceCount = 0, newLength, i = 0;
		for (i = 0; i < length; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		newLength = length + spaceCount * 2;
		//str[newLength] = '\0';
		char arr[] = new char[newLength];
		for (i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				arr[newLength - 1] = '0';
				arr[newLength - 2] = '2';
				arr[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				arr[newLength - 1] = str[i];
				newLength = newLength - 1;
			}
		}
		return String.valueOf(arr);
	}
	
	public static String usingArrayManipulation2(char[] str, int origLength) {
		int spaceCount = 0, newLength;
		char arr[];
		for(int i = 0; i < origLength; i++) {
			if(str[i] == ' ') {
				spaceCount++;
			}
		}
		newLength = origLength + 2*spaceCount;
		arr = new char[newLength];
		for(int i = 0, j = 0; i < origLength && j < newLength; i++, j++) {
			if(str[i] != ' ') {
				arr[j] = str[i];
			}else {
				arr[j] = '%';
				arr[j+1] = '2';
				arr[j+2] = '0';
				j = j + 2;
			}
		}
		
		return String.valueOf(arr);
	}
}
