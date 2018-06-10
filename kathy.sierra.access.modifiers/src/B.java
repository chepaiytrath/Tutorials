
public class B extends A {
	public static void main(String[] args) {
		B objB = new B();
		objB.method1();
	}
	private void method1() {
		/*int a = 10;
		protected int b = 10;
		private int c = 20;
		public int d = 30;*/
		
		int x;
		x = a;
		x = b;
		x = c;
		x = d;
		
		A objA = new A();
		x = objA.a;
		x = objA.b;
		x = objA.c;
		x = objA.d;
	}
}
