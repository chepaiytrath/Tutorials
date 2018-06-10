package p6;

public class InheritanceTest {
	public static void main(String[] args) {
		method123();
	}

	public static void method123() {
		A b1 = new B();
		//b1.method1(10, "JATIN");
		b1.method3();
	}
}

class A {
	public static int getVal() {
		return val;
	}

	public static int val = 1;

	public void method1(int x, String y) {
		System.out.println("method1 of class A");
	}

	static public void method2() {
		System.out.println("static method2 of class A");
	}

	public int method3(int x, String y) {
		System.out.println("method3 of class A");
		return 1;
	}
}

class B extends A {
	public void method1(int x, String y) {
		val = x;
		System.out.println("method1 of class B " + val);
	}

	static public void method2() {
		System.out.println("static method2 of class B");
	}

	public String method3(int x, String y) {
		System.out.println("method3 of class B");
		return 1;
	}
	
	public int method34(int x, String y) {
		return 1;
	}
	
	public int method34(int x, String y) {
		return null;
	}
}





class Animal {
	public void eat() throws Exception {
		// throws an Exception
	}
}

class Dog2 extends Animal {
	public void eat() {
		/* no Exceptions */}

	public static void main(String[] args) {
		Animal a = new Dog2();
		Dog2 d = new Dog2();
		d.eat(); // ok
		a.eat(); // compiler error -
		// unreported exception
	}
}