package designpattern.facade;

public class B implements Interface1 {
	Interface2 obj = new B1(2);

	@Override
	public String toString() {
		return "B";
	}

	@Override
	public Interface2 getProp() {
		return obj;
	}

}
