package designpattern.structural.strategy.approach1.displaybehaviour;

public class TextDisplayBehaviour implements IDisplayBehaviour {

	@Override
	public void display() {
		System.out.println("Displays like text");
	}

}
