package com.jatin.code.practice.goldmansachs;

public class ReverseWordsInString {
	public static void main(String[] args) {
		String str = new String("_I_am_Jatin_");
		System.out.println(printReverse(str));
	}

	private static String printReverse(String str) {
		String[] arr = str.split("_");
		StringBuffer sb = new StringBuffer();
		int i = arr.length - 1;
		while(i >= 0) {
			if(i == 0) {
				sb.append(arr[i]);
			}else {
				sb.append(arr[i]+"_");	
			}
			
			i--;
		}
		return sb.toString();
	}
}
