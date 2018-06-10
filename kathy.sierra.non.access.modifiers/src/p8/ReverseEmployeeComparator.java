package p8;

import java.util.Comparator;

public class ReverseEmployeeComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		//Descending
		return o2.getName().compareTo(o1.getName());
	}

}
