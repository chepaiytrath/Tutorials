package algorithms;

public class Q0008StringToInteger {
	public static void main(String[] args) {
		String s = "-12123123123123123123";
		System.out.println(myAtoi(s));
	}

	public static int myAtoi(String s) {
		int result = 0;
		s = s.trim();
		
		if(s.length() == 0) {
			return 0;
		}

		int index = 0;
		int sign = 1;
		if(s.charAt(0) == '-') {
			sign = -1;
			index++;
		}else if(s.charAt(0) == '+') {
			index++;
		}
		
		StringBuilder sb = new StringBuilder("");
		for(; index < s.length(); index++) {
			if(Character.isDigit(s.charAt(index))) {
				sb.append(s.charAt(index));
			}else {
				break;
			}
		}
		
		if(sb.length() == 0) {
			return 0;
		}
		
		try {
			result = Integer.parseInt(sb.toString());
		}catch(NumberFormatException e) {
			result = sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
		}
		
		return sign * result;
		
	}
}
