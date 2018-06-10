package algorithms;

public class Misc {
	public static void main(String args[]) {
		String s = "babcbaabcbaccba";
		System.out.println(manachersAlgorithm(s));
	}

	public static String longestPalindromicSubstring(String s) {
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
	
	public static int manachersAlgorithm(String s) {
		char[] input = new char[2*s.length() + 1];
		int index = 0;
		for(int i = 0; i < input.length; i++) {
			input[i] = i %2 == 0 ? '$' : s.charAt(index++);
		}
		int n = input.length;
		int[] output = new int[n];
		
		int start = 0, end = 0;
		for(int i = 0; i < n-1;) {
			while(start-1 >= 0 && end+1 < n && input[start-1] == input[end+1]) {
				start--;
				end++;
			}
			output[i] = end - start + 1;
			if(end == n-1) {
				break;
			}
			
			int newCenter = end + 1;
			for(int j = i+1; j <= end; j++) {
				int mirrorIndex = i - (j-i);
				int mirrorValue = output[mirrorIndex];
				if(mirrorIndex - mirrorValue/2 < start) {
					output[j] = 2*(end - j) + 1;
				}else {
					output[j] = mirrorValue;
				}
				if(j + mirrorValue / 2 == end) {
					newCenter = j;
					break;
				}
			}
			i = newCenter;
			start = i - output[i]/2;
			end = i + output[i]/2;
		}
		
		
		int longest_substring = 1;
		for (int i = 0; i < output.length; i++) {
			int val;
			val = output[i] / 2;
			if (longest_substring < val) {
				longest_substring = val;
			}
		}
		return longest_substring;
	}
	
}




/*
class Solution {
    public String longestPalindrome(String s) {
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
}*/