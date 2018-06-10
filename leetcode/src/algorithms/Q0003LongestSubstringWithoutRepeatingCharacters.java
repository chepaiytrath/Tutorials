package algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q0003LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		String s = "tmmzuxt";
		System.out.println(lengthOfLongestSubstring3(s));
	}

	public static int lengthOfLongestSubstring(String s) {
		int i = 0, j = 0, ans = 0, n = s.length();
		Set<Character> set = new HashSet<>();
		while (j < n) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				ans = Math.max(ans, j - i);
			} else {
				set.remove(s.charAt(i++));
			}
		}
		return ans;
	}

	public static int lengthOfLongestSubstring2(String s) {
		int i = 0, j = 0, ans = 0, n = s.length();
		Map<Character, Integer> map = new HashMap<>();
		while (i < n && j < n) {
			if (!map.containsKey(s.charAt(j))) {
				map.put(s.charAt(j++), j);
				ans = Math.max(ans, j - i);
			} else {
				i = Math.max(map.get(s.charAt(j)), i);
				map.put(s.charAt(j++), j);
				ans = Math.max(ans, j - i);
			}
		}
		return ans;
	}

	public static int lengthOfLongestSubstring3(String s) {
		int i = 0, j = 0, ans = 0, n = s.length();
		Map<Character, Integer> map = new HashMap<>();
		while(j < n) {
			if(map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);
			}
			ans = Math.max(ans, j - i + 1);
			map.put(s.charAt(j), j+1);
			j++;
		}
		return ans;
	}
}
