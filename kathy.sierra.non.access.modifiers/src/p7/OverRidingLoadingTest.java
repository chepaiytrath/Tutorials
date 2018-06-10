package p7;

public class OverRidingLoadingTest {

	public static void main(String[] args) {
		Parent obj = new Child();
		obj.method1(4);
		
		Child o2 = new Child();
		o2.method1(3, 4);
	
	}
} 

class Animal {
	void method1(int x) {
		System.out.println("Parent : method1");
	}
}

class Horse extends Animal{
	void method1(int x) {
		System.out.println("Child : method1 : overridden");
	}
	
	void method1(int x, int y) {
		System.out.println("Child : method1 : overloaded");
	}
}


interface Bounceable{
	
}