package designpattern.facade;

public class Facade {
	public Interface2 getInterface2(String input) {
		Interface1 i = null;
		if(input == "A1") {
			i = new A();
			return i.getProp();
		}else if (input == "B1") {
			i = new B();
			return i.getProp();
		}
		return null;
	}
	
	public A1 getA1() { 
		Interface1 obj = new A();
		return (A1) obj.getProp();
	}
	
	public B1 getB1() { 
		Interface1 obj = new B();
		return (B1) obj.getProp();
	}
	
	public int operateOnA1B1Values() {
		A1 a1 = getA1();
		B1 b1 = getB1();
		return a1.getX() + b1.getX();
	}
}
