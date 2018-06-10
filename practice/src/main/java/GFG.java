
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GFG {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			String str = sc.next();
			char[] charArray = str.toCharArray();
			Arrays.sort(charArray);
			str = String.valueOf(charArray);
			permute("", str);
			System.out.println();
		}
	}

	private static void permute(String chosen, String rem) {
		if(rem.length() == 0) {
			System.out.print(chosen+" ");
			return;
		}
		for(int i = 0; i < rem.length(); i++) {
			permute(chosen+rem.charAt(i), rem.substring(0, i)+rem.substring(i+1));
		}
	}
}
