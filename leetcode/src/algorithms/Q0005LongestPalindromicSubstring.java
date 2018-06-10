package algorithms;

import java.util.Arrays;

public class Q0005LongestPalindromicSubstring {
	public static void main(String args[]) {
		Q0005LongestPalindromicSubstring lps = new Q0005LongestPalindromicSubstring();
		//System.out.println(lps.longestPalindromeSubstringSimplest("abba".toCharArray()));
		//System.out.println(lps.longestPalindromicSubstringLinear("abbababba".toCharArray()));
		//System.out.println(lps.longestPalindromicSubstringLinear("dabax".toCharArray()));
		// System.out.println(lps.longestPalindromeSubstringEasy("babcbaabcbaccba".toCharArray()));
		// System.out.println(lps.longestPalindromeSubstringEasy("cdbabcbabdab".toCharArray()));
		//System.out.println(lps.returnLongestPalindromicSubstring("babcbaabcbaccba"));
		System.out.println(lps.manacherAlgoWithPadding1("babafasfasfad"));
		//System.out.println(lps.longestPalindromicSubstringLengthON("abaxabaxabb".toCharArray()));
	}

	public int manacherAlgoWithoutPadding(String s) {
		int longest_substring = 1, n = s.length();
		char[] input = s.toCharArray();
		int[] output = new int[n];
		
		for(int i = 0; i < n;) {
			int start = i;
			int end = i;
			
			while(start > 0 && end < n-1 && input[start-1] == input[end+1]) {
				start--;
				end++;
			}
			output[i] = end - start + 1;
			if(end == n-1) {
				break;
			}
			
			int newCenter = end + 1;
			for(int j = i+1; j <= end; j++) {
				int mirrorIndex = i - (j - i);
				int mirrorValue = output[mirrorIndex];
				
				if(mirrorIndex - (mirrorValue / 2) < start) {
					output[j] = 2*(end - j) + 1;
				}else {
					output[j] = mirrorValue;
				}
				
				if(j + mirrorValue/2 == end) {
					newCenter = j;
					break;
				}
			}
			
			i = newCenter;
			/*start = i - output[i]/2;
			end = i + output[i]/2;*/
		}
		
		
		return longest_substring;
	}
	
	public int manacherAlgoWithPadding(String s) {
		int longest_substring = 1, n = s.length();
		char[] arr = s.toCharArray();
		char[] input = new char[2*n + 1];
		int[] output = new int[input.length];
		
		for(int i = 0, index = 0; i < input.length; i++) {
			if(i % 2 == 0) {
				input[i] = '#';
			}else {
				input[i] = arr[index++];
			}
		}
		int start = 0;
		int end = 0;
		for(int i = 0; i < input.length - 1;) {
			while(start > 0 && end < input.length - 1 && input[start-1] == input[end+1]) {
				start--;
				end++;
			}
			output[i] = end - start + 1;
			
			if(end == input.length-1) {
				break;
			}
			//int newCenter = end + (i % 2 == 0 ? 1 : 0);
			int newCenter = end + 1;
			
			for(int j = i + 1; j <= end; j++) {
				int mirrorIndex = i - (j - i);
				int mirrorValue = output[mirrorIndex];
				
				if(mirrorIndex - (mirrorValue/2) < start) {
					output[j] = 2*(end - j) + 1;
				}else {
					output[j] = mirrorValue;
				}
				
				if(j + mirrorValue/2 == end) {
					newCenter = j;
					break;
				}
			}
			i = newCenter;
			end = i + output[i] / 2;
			start = i - output[i] / 2;
		}
		
		for (int i = 0; i < output.length; i++) {
			int val;
			val = output[i] / 2;
			if (longest_substring < val) {
				longest_substring = val;
			}
		}
		return longest_substring;
	}
	
	public String manacherAlgoWithPadding1(String s) {
		int longest_substring = Integer.MIN_VALUE, n = s.length();
		char[] arr = s.toCharArray();
		char[] input = new char[2*n + 1];
		Indexes[] output = new Indexes[input.length];
		for(int i = 0; i < output.length; i++) {
			output[i] = new Indexes(0, 0, 0);
		}
		
		int a = 0, b= 0;
		for(int i = 0, index = 0; i < input.length; i++) {
			if(i % 2 == 0) {
				input[i] = '#';
			}else {
				input[i] = arr[index++];
			}
		}
		int start = 0;
		int end = 0;
		for(int i = 0; i < input.length - 1;) {
			while(start > 0 && end < input.length - 1 && input[start-1] == input[end+1]) {
				start--;
				end++;
			}
			output[i].setLength(end - start + 1);
			output[i].setStart(start);
			output[i].setEnd(end);
			
			
			if(end == input.length-1) {
				break;
			}
			//int newCenter = end + (i % 2 == 0 ? 1 : 0);
			int newCenter = end + 1;
			
			for(int j = i + 1; j <= end; j++) {
				int mirrorIndex = i - (j - i);
				int mirrorValue = output[mirrorIndex].getLength();
				
				if(mirrorIndex - (mirrorValue/2) < start) {
					output[j].setLength(2*(end - j) + 1);
				}else {
					output[j].setLength(mirrorValue);
				}
				
				if(j + mirrorValue/2 == end) {
					newCenter = j;
					break;
				}
			}
			i = newCenter;
			end = i + output[i].getLength() / 2;
			start = i - output[i].getLength() / 2;
		}
		
		for (int i = 0; i < output.length; i++) {
			int val;
			val = output[i].getLength() / 2;
			if (longest_substring < val) {
				longest_substring = val;
				a = output[i].getStart();
				b = output[i].getEnd();
			}
		}
		return s.substring(a/2, b/2);
	}
	
	//Solutions
	public String longestPalindromeSubstringLengthON2WithoutPadding(String s) {
		int start = 0, end = 0, n = s.length();
		for(int i = 0; i < n; i++) {
			int x = i-1;
			int y = i+1;
			while(x >= 0 && y < n && s.charAt(x) == s.charAt(y)) {
				x--;
				y++;
			}
			if((--y - ++x) > (end - start)) {
				start = x;
				end = y;
			}
			
			x = i;
			y = i+1;
			while(x >= 0 && y < n && s.charAt(x) == s.charAt(y)) {
				x--;
				y++;
			}
			
			if((--y - ++x) > (end - start)) {
				start = x;
				end = y;
			}
		}
		return s.substring(start, end+1);
	}
	
	public int longestPalindromeSubstringLengthON2WithPadding(char arr[]) {
		char[] newArr = new char[(2*arr.length) + 1];
		for(int x = 0, index = 0; x < newArr.length; x++) {
			if(x%2 == 0) {
				newArr[x] = '#';
			}else {
				newArr[x] = arr[index++];
			}
		}
		
		int longest_substring = 0;
		for(int i = 0; i < newArr.length; i++) {
			int start = i-1;
			int end = i+1;
			int palindrome = 1;
			//No need for i, i+1 because of # padding between elements
			while(start >= 0 && end < newArr.length && newArr[start] == newArr[end]) {
				palindrome += 2;
				start--;
				end++;
			}
			longest_substring = Math.max(longest_substring, palindrome);
			if(end == newArr.length) {
				break;
			}
		}
		return longest_substring/2;
	}
	
	public static String longestPalindromeSubstringLengthON2WithPadding(String s) {
		char[] input = new char[2*s.length() + 1];
		int index = 0;
		for(int i = 0; i < input.length; i++) {
			input[i] = i %2 == 0 ? '$' : s.charAt(index++);
		}
		int x=0, y=0;
		int longest_palindrome = 1;
		for(int i = 0; i < input.length; i++) {
			int start = i-1;
			int end = i+1;
			int palindrome = 1;
			while(start>=0 && end<input.length && input[start] == input[end]) {
				palindrome += 2;
				start--;
				end++;
			}
			if(palindrome > longest_palindrome) {
				longest_palindrome = palindrome;
				--end;
				++start;
				y = end/2;
				x = start/2;
			}
			if(end == input.length-1) {
				break;
			}
		}
		return s.substring(x,y);
	}
	
	
	// Solutions
	/**
	 * Linear time Manacher's algorithm to find longest palindromic substring. There
	 * are 4 cases to handle 
	 * Right side palindrome : Palindrome of characters while searching for new center at the right of current character
	 * Proper suffix : ends meet
	 * Proper prefix : heads meet
	 * Case 1 : Right side palindrome is totally contained
	 * under current palindrome. In this case do not consider this as center. 
	 * Case 2 : Current palindrome is proper suffix of input. Terminate the loop in this
	 * case. No better palindrome will be found on right. 
	 * I.E. U REACH THE END OF THE INPUT WHILE SEARCHING FOR PALINDROME
	 * Case 3 : Right side palindrome is proper suffix and its corresponding left side palindrome is
	 * proper prefix of current palindrome. Make largest such point as next center.
	 * Case 4 : Right side palindrome is proper suffix but its left corresponding
	 * palindrome is beyond current palindrome. Do not consider this as center
	 * because it will not extend at all.
	 *
	 * To handle even size palindromes replace input string with one containing $
	 * between every input character and in start and end.
	 */
	public int longestPalindromicSubstringLengthON(char input[]) {
		int index = 0;
		// preprocess the input to convert it into type abc -> $a$b$c$ to handle even
		// length case.
		// Total size will be 2*n + 1 of this new array.
		char newInput[] = new char[2 * input.length + 1];
		for (int i = 0; i < newInput.length; i++) {
			if (i % 2 != 0) {
				newInput[i] = input[index++];
			} else {
				newInput[i] = '$';
			}
		}

		// create temporary array for holding largest palindrome at every point. There
		// are 2*n + 1 such points.
		int T[] = new int[newInput.length];
		int start = 0;
		int end = 0;
		// here i is the center.
		for (int i = 0; i < newInput.length;) {
			// expand around i. See how far we can go.
			while (start > 0 && end < newInput.length - 1 && newInput[start - 1] == newInput[end + 1]) {
				start--;
				end++;
			}
			// set the longest value of palindrome around center i at T[i]
			T[i] = end - start + 1;

			// this is CASE 2. Current palindrome is proper suffix of input. No need to
			// proceed. Just break out of loop.
			if (end == T.length - 1) {
				break;
			}
			// Mark newCenter to be either end or end + 1 depending on if we dealing with
			// even or old number input. EVEN : $ ODD : ACTUAL INPUT
			int newCenter = end + (i % 2 == 0 ? 1 : 0);

			for (int j = i + 1; j <= end; j++) {

				// i - (j - i) is left mirror. Its possible left mirror might go beyond current
				// center palindrome. So take minimum
				// of either left side palindrome or distance of j to end.
				T[j] = Math.min(T[i - (j - i)], 2 * (end - j) + 1);
				// Only proceed if we get CASE 3. This check is to make sure we do not pick j as
				// new center for CASE 1 or CASE 4
				// As soon as we find a center lets break out of this inner while loop.
				if (j + T[i - (j - i)] / 2 == end) {
					newCenter = j;
					break;
				}
			}
			// make i as newCenter. Set right and left to atleast the value we already know
			// should be matching based of left side palindrome.
			i = newCenter;
			end = i + T[i] / 2; // T[i] / 2 : Elements in one side of palindrome
			start = i - T[i] / 2;
		}

		// find the max palindrome in T and return it.
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < T.length; i++) {
			int val;
			/*
			 * if(i%2 == 0) { val = (T[i] -1)/2; } else { val = T[i]/2; }
			 */
			val = T[i] / 2;
			if (max < val) {
				max = val;
			}
		}
		return max;
	}

	public int longestPalindromeDP(char[] str) {
		boolean T[][] = new boolean[str.length][str.length];

		for (int i = 0; i < T.length; i++) {
			T[i][i] = true;
		}

		int max = 1;
		for (int l = 2; l <= str.length; l++) {
			int len = 0;
			for (int i = 0; i < str.length - l + 1; i++) {
				int j = i + l - 1;
				len = 0;
				if (l == 2) {
					if (str[i] == str[j]) {
						T[i][j] = true;
						len = 2;
					}
				} else {
					if (str[i] == str[j] && T[i + 1][j - 1]) {
						T[i][j] = true;
						len = j - i + 1;
					}
				}
				if (len > max) {
					max = len;
				}
			}
		}
		return max;
	}
}

class Indexes{
	public Indexes(int length, int start, int end) {
		super();
		this.length = length;
		this.start = start;
		this.end = end;
	}
	private int length;
	private int start;
	private int end;
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	@Override
	public String toString() {
		return "Indexes [length=" + length + ", start=" + start + ", end=" + end + "]";
	}
}