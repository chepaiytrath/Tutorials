package designpattern.structural.strategy.approach1.flybehaviour;

public class SimpleFlyBehaviour implements IFlyBehaviour {
	@Override
	public void fly() {
		System.out.println("Flies simply");
	}
}
