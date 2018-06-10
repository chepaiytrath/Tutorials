package p7;

public class instanceOfTest {
	public static void main(String[] args) {
		/*A a = new A();
		System.out.println(a instanceof C);*/
		
		boolean b1 = true, b2 = false;
		boolean b3 = (b1 == true) && (b2 = true); // will b2 be set to true?
		System.out.println(b3 + " " + b2);
	}
}

class A{
	
}
class B extends A{
	
}


class C{
	
}