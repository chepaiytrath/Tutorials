package algorithms;

public class Q0006ZigZagConversion {
	public static void main(String[] args) {
		String s = "AB";
		int countRows = 1;
		System.out.println(convert(s, countRows));
	}

	public static String convert(String s, int numRows) {
		if(numRows == 1) {
			return s;
		}
		
		StringBuilder[] arr = new StringBuilder[numRows];
		for(int i = 0; i < numRows; i++) {
			arr[i] = new StringBuilder("");
		}
		
		
		int index = 0;
		int incr = 0;
		for(int i = 0; i < s.length(); i++) {
			arr[index].append(s.charAt(i));
			if(index == 0) {
				incr = 1;
			}
			if(index == numRows-1) {
				incr = -1;
			}
			index = index + incr;
		}
		
		StringBuilder sb = new StringBuilder("");
		for(int i = 0; i < numRows; i++) {
			sb.append(arr[i]);
		}
		return sb.toString();
	}
}
