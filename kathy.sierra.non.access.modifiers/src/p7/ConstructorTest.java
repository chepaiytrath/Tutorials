package p7;

public class ConstructorTest {
	public static void main(String[] args) {
		/*Child c1 = new Child();
		System.out.println("\n");
		Child c2 = new Child();
		System.out.println("\n");
		Child c3 = new Child();
		System.out.println("\n");*/
		
		
		new Child();
	}
}

class Parent {
	Parent() {
		System.out.println("Parent default constructor");
	}

	{
		System.out.println("Parent init1 block");
	}

	static {
		System.out.println("Parent static1 block");
	}

	{
		System.out.println("Parent init2 block");
	}

	static {
		System.out.println("Parent static2 block");
	}

}

class Child extends Parent {
	int x;
	int y;

	{
		System.out.println("Child init1 block");
	}

	static {
		System.out.println("Child static1 block");
	}

	{
		System.out.println("Child init2 block");
	}

	static {
		System.out.println("Child static2 block");
	}

	Child() {
		this(method());
		System.out.println("Child default constructor");
	}

	Child(int val) {
		this(val, method());
		System.out.println("Child parameterized1 constructor");
		this.x = val;
	}

	Child(int val, int val2) {
		System.out.println("Child parameterized2 constructor");
		this.x = val;
		this.y = val2;
	}

	static int method() {
		return 10;
	}
}