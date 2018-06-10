package designpattern.structural.strategy.approach1;

import designpattern.structural.strategy.approach1.displaybehaviour.GraphicsDisplayBehaviour;
import designpattern.structural.strategy.approach1.flybehaviour.JetFlyBehaviour;
import designpattern.structural.strategy.approach1.quackbehaviour.NoQuackBehaviour;

public class Client {
	public static void main(String[] args) {
		Duck duck = new Duck(new GraphicsDisplayBehaviour(), new JetFlyBehaviour(), new NoQuackBehaviour());
		duck.fly();
		duck.quack();
		duck.display();
	}
}