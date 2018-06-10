package designpattern.strategy.approach1.flybehaviour;

public class NoFlyBehaviour implements IFlyBehaviour {
	@Override
	public void fly() {
		System.out.println("Doesn't fly");
	}
}
