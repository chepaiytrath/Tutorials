package p1;

public abstract class Vehicle {
	private abstract void method1(); //only public/protected are allowed for an abstrat method
	
	public abstract final void method2(); //abstract final not allowed
		
	public final void method3() {
		System.out.println("method3 of clas Vehicle");
	}
	
	public abstract void method4();
	
	public abstract static void method5();
}
