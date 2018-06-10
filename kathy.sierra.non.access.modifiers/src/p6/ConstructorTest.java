package p6;

public class ConstructorTest {
	public static void main(String[] args) {
		Animal2 obj = new Animal2(1);
	}
}

class Animal2{
	public Animal2(int x) {
		System.out.println("constructor");
		method();
	}
	
	private void method() {
		System.out.println("method");
	}
}