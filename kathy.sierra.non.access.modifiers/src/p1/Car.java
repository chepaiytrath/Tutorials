package p1;

public class Car extends Vehicle {
	public final void method3() { // cannot override
		System.out.println("method3 of clas Car");
	}

	public final void method3(String s) { // can overload
		System.out.println("method3 of clas Car");
	}

	@Override
	public final void method2() {

	}

	public void method4(String s) {

	}

	@Override
	public void method4() {
		// TODO Auto-generated method stub
		
	}
}
