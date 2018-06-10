package designpattern.facade;

public class A implements Interface1 {
	Interface2 obj = new A1(1);

	@Override
	public String toString() {
		return "A";
	}

	@Override
	public Interface2 getProp() {
		return obj;
	}
	
}
