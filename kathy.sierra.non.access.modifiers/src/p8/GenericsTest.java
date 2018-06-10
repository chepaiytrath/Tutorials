package p8;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		int x = list.get(0);
		System.out.println(x);
		
		method(list);
		
		System.out.println(list.toString());
		
		int total = 0;
		for(Integer i : list) {
			total += i;
		}
		System.out.println(total);
		
		/*List list2 = new ArrayList();
		list2.add(1);
		int y = (Integer)list2.get(0);
		System.out.println(y);*/
		
	}
	
	private static void method(List list) {
		list.add(2);
		list.add("123");
	}
}
