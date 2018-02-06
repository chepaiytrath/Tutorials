package com.jatin.code.practice.misc;

public class GoldmanSachsHackerrank {

	public String getSmallestNumber(String pattern) {

		char[] charArray = pattern.toCharArray();

		int start = 0;
		String number = null;

		boolean foundI = false;
		boolean foundD = false;
		int beginI = -1;
		int beginD = 0;
		int endD = 0;
		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];

			if (c == 'I') {

				if (foundD) {
					int currentCursor = start;

					if (beginI >= 0) {
						if (number == null) {
							number = "" + ++currentCursor;
						}

						for (int x = beginI; x < beginD - 1; x++) {
							number += ++currentCursor;
						}

						currentCursor = currentCursor + (endD - beginD + 1) + 1;
						number += currentCursor;
					}

					if (number == null) {
						currentCursor = ++currentCursor + (endD - beginD) + 1;
						number = "" + currentCursor;
					}

					start = currentCursor;

					for (int x = beginD; x <= endD; x++) {
						number += --currentCursor;
					}

					foundD = false;
					foundI = false;
				}

				if (!foundI) {
					foundI = true;
					beginI = i;
				}
			}

			if (c == 'D') {
				if (!foundD) {
					foundD = true;
					beginD = i;
					endD = i;
				} else {
					endD = i;
				}
			}
		}

		if (start <= charArray.length) {
			System.out.println("Pending::foundD:" + foundD + "::foundI::" + foundI);

			if (foundI && foundD) {
				int currentCursor = start;

				if (beginI >= 0) {
					if (number == null) {
						number = "" + ++currentCursor;
					}

					for (int x = beginI; x < beginD - 1; x++) {
						number += ++currentCursor;
					}

					currentCursor = currentCursor + (endD - beginD + 1) + 1;
					number += currentCursor;
				}

				if (number == null) {
					currentCursor = ++currentCursor + (endD - beginD) + 1;
					number = "" + currentCursor;
				}

				start = currentCursor;

				for (int x = beginD; x <= endD; x++) {
					number += --currentCursor;
				}
			} else if (foundI) {
				if (number == null) {
					number = "";
				}
				for (int j = start + 1; j <= charArray.length + 1; j++) {
					number += j;
				}
			} else if (foundD) {
				if (number == null) {
					number = "";
				}
				for (int j = charArray.length + 1; j >= start + 1; j--) {
					number += j;
				}
			}
		}
		return number;
	}

	public static void main(String[] args) {
		GoldmanSachsHackerrank patternMatcher = new GoldmanSachsHackerrank();
		System.out.println(patternMatcher.getSmallestNumber("IIIDDDII"));
		// System.out.println(patternMatcher.getSmallestNumber("DDDI"));
		// System.out.println(patternMatcher.getSmallestNumber("IIDDDI"));
		// System.out.println(patternMatcher.getSmallestNumber("DDIDDIIDI"));
		// System.out.println(patternMatcher.getSmallestNumber("DDDIIIDDI"));
		// System.out.println(patternMatcher.getSmallestNumber("IX"));
		// System.out.println(patternMatcher.getSmallestNumber("DDX"));
		// System.out.println(patternMatcher.getSmallestNumber("IIX"));
		// System.out.println(patternMatcher.getSmallestNumber("DIDIX"));
	}
}
