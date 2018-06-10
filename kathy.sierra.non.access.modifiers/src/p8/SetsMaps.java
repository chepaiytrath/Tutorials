package p8;

import java.util.Set;
import java.util.TreeSet;

public class SetsMaps {
	public static void main(String[] args) {
		Set s = new TreeSet();
		s.add("asd");
		s.add("zxc");
		s.add("qwe");
		s.add(new Integer(10));
		
		for(Object o : s)
			System.out.print(o + " ");
	}
}
