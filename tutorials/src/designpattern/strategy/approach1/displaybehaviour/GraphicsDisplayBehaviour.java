package designpattern.strategy.approach1.displaybehaviour;

public class GraphicsDisplayBehaviour implements IDisplayBehaviour {

	@Override
	public void display() {
		System.out.println("Displays like graphics");
	}

}
