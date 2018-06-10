package p5;

interface Gadget {
	void doStuff();
}

abstract class Electronic2 {
	void getPower() {
		System.out.print("plug in ");
	}
}

public class Tablet extends Electronic2 implements Gadget {
	/*void doStuff() {
		System.out.print("show book ");
	}*/

	public static void main(String[] args) {
		new Tablet().getPower();
		new Tablet().doStuff();
	}

	@Override
	public void doStuff() {
		// TODO Auto-generated method stub
		
	}
}
