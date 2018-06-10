package p8;

import java.util.*;

class SearchObjArray {
	public static void main(String[] args) {
		/*String[] sa = { "one", "two", "three", "four" };
		Arrays.sort(sa); // #1
		for (String s : sa)
			System.out.print(s + " ");
		System.out.println("\none = " + Arrays.binarySearch(sa, "one")); // #2
		System.out.println("now reverse sort");
		ReSortComparator rs = new ReSortComparator(); // #3
		Arrays.sort(sa, rs);
		for (String s : sa)
			System.out.print(s + " ");
		System.out.println("\none = " + Arrays.binarySearch(sa, "one")); // #4
		System.out.println("one = " + Arrays.binarySearch(sa, "one", rs)); // #5

		*/
		
		List<Integer> iL = new ArrayList<Integer>();
		for (int x = 0; x < 3; x++)
			iL.add(x);
		Object[] oa = iL.toArray(); // create an Object array
		Integer[] ia2 = new Integer[1];
		ia2 = iL.toArray(ia2);
		System.out.println(Arrays.asList(ia2));
	}

	static class ReSortComparator implements Comparator<String> { // #6
		public int compare(String a, String b) {
			return b.compareTo(a); // #7
		}
	}
}