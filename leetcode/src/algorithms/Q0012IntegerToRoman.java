package algorithms;

import java.util.HashMap;
import java.util.Map;

public class Q0012IntegerToRoman {

	public static void main(String[] args) {
		int x = 1849;
		System.out.println(intToRoman(x));
	}

	public static String intToRoman(int num) {
		int[] arr = Integer.toString(num).chars().map(c -> c-='0').toArray();
		
		StringBuilder roman = new StringBuilder();
		Map<Integer, Character> romans = new HashMap<>();
		romans.put(1, 'I');
		romans.put(5, 'V');
		romans.put(10, 'X');
		romans.put(50, 'L');
		romans.put(100, 'C');
		romans.put(500, 'D');
		romans.put(1000, 'M');
		
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			StringBuilder tempRoman = new StringBuilder();
			int pow = (int) Math.pow(10, (n - 1) - i);
			
			int val = arr[i];
			if(val > 0 && val < 4) {
				while(val > 0) {
					tempRoman.append(romans.get(pow));
					val--;
				}
			}else if (val == 4) {
				tempRoman.append(romans.get(pow));
				char get5 = get5(romans.get(pow));
				tempRoman.append(get5);
			}else if (val == 5) {
				tempRoman.append(get5(romans.get(pow)));
			}else if (val > 5 && val < 9) {
				char get5 = get5(romans.get(pow));
				tempRoman.append(get5);
				int tempVal = val - 5;
				while(tempVal > 0) {
					tempRoman.append(romans.get(pow));
					tempVal--;
				}
			}else if (val == 9) {
				tempRoman.append(romans.get(pow));
				char get10 = get10(romans.get(pow));
				tempRoman.append(get10);
			}
			roman.append(tempRoman);
		}

		return roman.toString();
	}

	private static char get5(Character roman) {
		Map<Character, Character> map5 = new HashMap<>();
		map5.put('I', 'V');
		map5.put('X', 'L');
		map5.put('C', 'D');
		return map5.get(roman);
	}

	private static char get10(Character roman) {
		Map<Character, Character> map5 = new HashMap<>();
		map5.put('I', 'X');
		map5.put('X', 'C');
		map5.put('C', 'M');
		return map5.get(roman);
	}
}
