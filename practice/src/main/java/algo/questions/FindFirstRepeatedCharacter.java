package algo.questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindFirstRepeatedCharacter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		while (t-- > 0) {
			String input = sc.nextLine();
			printFirstRepeatedChar(input);
		}
	}

	private static void printFirstRepeatedChar(String input) {
		Map<Character, Entry> map = new HashMap<Character, Entry>();
		int i = 0;
		while(i < input.length()) {
			if(!map.containsKey(input.charAt(i))) {
				map.put(input.charAt(i), new Entry(i));
			}else {
				map.get(input.charAt(i)).incCount();
			}
			i++;
		}
		int minIndex = Integer.MAX_VALUE;
		for(Character ch : map.keySet()) {
			if(map.get(ch).getCount() > 1 && minIndex > map.get(ch).getFirstIndex()) {
				minIndex = map.get(ch).getFirstIndex();
			}
		}
		if(minIndex == Integer.MAX_VALUE) {
			System.out.println("-1");
		}else {
			System.out.println(input.charAt(minIndex));
		}
	}
}

class Entry {
	private int count;
	private int firstIndex;

	Entry(int i) {
		super();
		this.firstIndex = i;
		this.count = 1;
	}

	public void incCount() {
		this.count++;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getFirstIndex() {
		return firstIndex;
	}

	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}
}
