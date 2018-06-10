package designpattern.structural.facade;

public class A1 implements Interface2 {

	int x = 5;

	public A1(int x) {
		super();
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	@Override
	public String toString() {
		return "A1";
	}

}
