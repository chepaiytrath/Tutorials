package algorithms;

public class Q0009PalindromeNumber {
	public static void main(String[] args) {
		int x = 10;
		System.out.println(isPalindromeReverseTillHalf(x));
	}

	public static boolean isPalindrome(int x) {
		if(x < 0) {
			return false;
		}
		/*if(x == 0) {
			return true;
		}*/
		
		boolean isPalindrome = false;
		int input = x, output = 0;
		while(x!=0) {
			output = (output * 10) + (x % 10);
			x = x/10;
		}
		isPalindrome = input == output;
		return isPalindrome;
		
		//Improvement : need to reverse only till half
	}
	
	public static boolean isPalindromeReverseTillHalf(int x) {
		if(x<0 || (x > 0 && x%10 == 0)) {
			return false;
		}
		int reversed = 0;
		while(x > reversed) {
			reversed = (reversed * 10) + (x%10); 
			x = x/10;
		}
		return x == reversed || x == reversed/10;
	}
}
