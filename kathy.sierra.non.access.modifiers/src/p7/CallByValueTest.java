package p7;

public class CallByValueTest {
	static int[] arr1 = new int[10];
	private static void method1() {
 		for(int x : arr1) {
			System.out.println(x);
		}
	}
	public static void main(String[] args) {
		Employee e1 = new Employee(1);
		System.out.println("e1 : x = "+e1.x);
		System.out.println("e1 : y = "+e1.y);
		method2(e1);
		System.out.println("e1 : x = "+e1.x);
		System.out.println("e1 : y = "+e1.y);
		
		
		/*int x = 10, y = 20;
		swap(x, y);
		System.out.println("x = "+x);
		System.out.println("y = "+y);*/
	}
	private static void swap(int x, int y) {
		int temp = x;
		x = y;
		y = temp;
		System.out.println("swapped x = "+x);
		System.out.println("swapped y = "+y);
	}
	private static void method2(Employee e2) {
		System.out.println("e2--e1 : x = "+e2.x);
		System.out.println("e2--e1 : y = "+e2.y);
		
		e2.y = 2;
		e2 = new Employee(100,100);
		System.out.println("e2--e1 : x = "+e2.x);
		System.out.println("e2--e1 : y = "+e2.y);
	}
}

class Employee{
	int x;
	int y;
	public Employee(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Employee(int x) {
		this.x = x;
	}
}