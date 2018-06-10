package designpattern.structural.strategy.approach1.flybehaviour;

public class JetFlyBehaviour implements IFlyBehaviour {

	@Override
	public void fly() {
		System.out.println("Flies like a jet");
	}

}
