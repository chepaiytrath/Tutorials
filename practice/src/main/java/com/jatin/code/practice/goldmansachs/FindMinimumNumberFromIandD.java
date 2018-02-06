package com.jatin.code.practice.goldmansachs;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class FindMinimumNumberFromIandD {

	public static void main(String[] args) {
		System.out.println(getSmallestNumber("DDIDDIID"));
	}
	
	public static String getSmallestNumber(String pattern) {
		String input = pattern;
		String output = findMinimumNumberFromPattern(input);
		return output;
	}

	private static String findMinimumNumberFromPattern(String input) {
		if(null == input) {
			return "-1";
		}
		
		String output = new String();                               
		char scenario = checkScenario(input);
		switch(scenario) {
		case 'D' : 
			output = findMinForDOnly(input.length());
			break;
			
		case 'I' : 
			output = findMinForIOnly(input.length());
			break;
			
		case 'M' : 
			output = findMinForMix(input);
			break;
			
		case 'U' : 
			output = "-1";
			break;
		}
		 
		return output;
	}
	
	private static String findMinForMix(String input) {
		String output = new String();
		Set<Integer> usedNumberSet = new HashSet<Integer>();
		int startIndex = 0;
		char begChar = input.charAt(0);
		if(begChar == 'I') {
			output = output + 1;
			usedNumberSet.add(1);
		}else if(begChar == 'D') {
			int countConsecutiveDs = findCountConsecutiveChars(input, 0, 'D');
			String outputForLeadingDs = findMinForDOnly(countConsecutiveDs);
			output = output + outputForLeadingDs;
			addUsedNumbersToUsedNumberSet(usedNumberSet, outputForLeadingDs);
			startIndex = startIndex + countConsecutiveDs;
		}
		output = fillOutputForRemainingInput(input, output, startIndex, usedNumberSet);
		return output;
	}
	
	private static String fillOutputForRemainingInput(String input, 
			String output, int startIndex, Set<Integer> usedNumberSet) {
		//fill output for Is
		int a = 0, highestUsed = 0, c = 0, d = 0;
		for(int i = startIndex; i < input.length(); ) {
			if(input.charAt(i) == 'I') {
				int countConsecutiveIs = findCountConsecutiveChars(input, i, 'I');
				highestUsed = findHighestUsedNumber(usedNumberSet);
				for(int j = highestUsed + 1; j <= highestUsed + (countConsecutiveIs - 1); j++) {
					output = output + j;
				}
				addUsedNumbersToUsedNumberSet(usedNumberSet, output);
				int countConsecutiveDs = findCountConsecutiveChars(input, i+1, 'D');
				highestUsed = findHighestUsedNumber(usedNumberSet);
				int value = countConsecutiveDs + highestUsed + 1;
				output = output + value;
				i = i + countConsecutiveIs; //next D
			}else if(input.charAt(i) == 'D') {
				int countConsecutiveDs = findCountConsecutiveChars(input, i, 'D');
				highestUsed = findHighestUsedNumber(usedNumberSet);
				for(int k = highestUsed - 1; k >= highestUsed - countConsecutiveDs; k--) {
					output = output + k;
				}
				i = i + countConsecutiveDs; //next I
			}
			
			addUsedNumbersToUsedNumberSet(usedNumberSet, output);
		}
		return output;
	}
	
	private static int findHighestUsedNumber(Set<Integer> usedNumberSet) {
		return Collections.max(usedNumberSet);
	}

	private static void addUsedNumbersToUsedNumberSet(Set<Integer> usedNumberSet, String outputForLeadingDs) {
		for(char c : outputForLeadingDs.toCharArray()) {
			usedNumberSet.add(Character.getNumericValue(c));
		}
	}

	private static int findCountConsecutiveChars(String input, int begIndex, char c) {
		int count = 0;
		boolean foundChar = false;
		for(int i = begIndex; i < input.length(); i++) {
			if(input.charAt(i) == c) {
				count++;
				foundChar = true;
			}else {
				if(foundChar) {
					break;
				}
			}
		}
		return count;
	}

	private static String findMinForIOnly(int length) {
		String output = new String();
		int size = length + 1;
		for(int i = 1; i <= size; i++) {
			output = output + i;
		}
		return output;
	}

	private static String findMinForDOnly(int length) {
		String output = new String();
		int size = length + 1;
		for(int i = size; i >= 1; i--) {
			output = output + i;
		}
		return output;
	}

	private static char checkScenario(String input) {
		if(Pattern.matches("(D){1,8}", input)) {
			return 'D';
		}else if (Pattern.matches("(I){1,8}", input)) {
			return 'I';
		}else if (Pattern.matches("[D,I]{1,8}", input)) {
			return 'M';
		}
		return 'U';
	}

}