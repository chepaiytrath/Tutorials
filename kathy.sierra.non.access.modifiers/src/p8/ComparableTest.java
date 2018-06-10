package p8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparableTest {
	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();
		Employee e = new Employee("rahul");
		list.add(e);
		e = new Employee("jatin");
		list.add(e);
		e = new Employee("rohit");
		list.add(e);
		e = new Employee("gaurav");
		list.add(e);
		Collections.sort(list);
		System.out.println(list);
		
		System.out.println();
		
		Collections.sort(list, new ReverseEmployeeComparator());
		System.out.println(list);
	
		
		Employee[] arr = new Employee[4];
		arr[0] = new Employee("rahul");
		arr[1] = new Employee("jatin");
		arr[2] = new Employee("rohit");
		arr[3] = new Employee("gaurav");
		Arrays.sort(arr, new ReverseEmployeeComparator());
		System.out.println(Arrays.asList(arr));
		Collections.sort(Arrays.asList(arr), new ReverseEmployeeComparator());
		System.out.println(Arrays.asList(arr));
		
		
		int[] arr2 = new int[3];
		arr2[0] = 20;
		arr2[1] = 6;
		arr2[2] = 10;
		
		Arrays.sort(arr2);
		
		for(int x : arr2) {
			System.out.print(x + " ");
		}

	}
}
