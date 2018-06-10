package p8;

import java.util.Arrays;

public class ArraysMethodTest {
	public static void main(String[] args) {
		int[] arr1 = new int[3];
		arr1[0] = 0;
		arr1[1] = 1;
		arr1[2] = 2;
		
		int[] arr2 = new int[4];
		arr2[0] = 0;
		arr2[1] = 1;
		arr2[2] = 2;
		arr2[3] = 3;
		
		System.out.println(Arrays.equals(arr1, arr2));
		
		
		
		Student[] stuArr1 = new Student[2];
		stuArr1[0] = new Student("jatin");
		stuArr1[1] = new Student("gaurav");
		
		Student[] stuArr2 = new Student[3];
		stuArr2[0] = new Student("jatin");
		stuArr2[1] = new Student("gaurav");
		stuArr2[2] = new Student("gaurav");
		
		System.out.println(Arrays.equals(stuArr1, stuArr2));
		
		
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(stuArr1));
	}
	
	
}


class Student{
	private String name;

	public Student(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}
	
}