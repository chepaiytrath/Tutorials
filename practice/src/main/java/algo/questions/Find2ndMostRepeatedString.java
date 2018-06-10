package algo.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Find2ndMostRepeatedString {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		while (t-- > 0) {
			String n = sc.nextLine();
			String[] arr = sc.nextLine().split(" ");
			print2ndMostRepeatedString(arr);
		}
	}

	private static void print2ndMostRepeatedString(String[] arr) {
		Map<String, Integer> countMap = new HashMap<String, Integer>();
		for(String str : arr) {
			if(!countMap.containsKey(str)) {
				countMap.put(str, 1);
			}else {
				countMap.put(str, countMap.get(str)+1);
			}
		}
		ArrayList<Integer> countList= new ArrayList<Integer>(countMap.values());
		Collections.sort(countList);
		for(String str : countMap.keySet()) {
			if(countMap.get(str) == countList.get(countList.size()-2)) {
				System.out.println(str);
				break;
			}
		}
		
	}
}
