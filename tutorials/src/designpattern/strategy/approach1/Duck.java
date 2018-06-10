package designpattern.strategy.approach1;

import designpattern.strategy.approach1.displaybehaviour.IDisplayBehaviour;
import designpattern.strategy.approach1.flybehaviour.IFlyBehaviour;
import designpattern.strategy.approach1.quackbehaviour.IQuackBehaviour;

public class Duck {
	IDisplayBehaviour displayer;
	IFlyBehaviour flyer;
	IQuackBehaviour quacker;

	public Duck(IDisplayBehaviour displayer, IFlyBehaviour flyer, IQuackBehaviour quacker) {
		super();
		this.displayer = displayer;
		this.flyer = flyer;
		this.quacker = quacker;
	}

	public void display() {
		displayer.display();
	}
	
	public void fly() {
		flyer.fly();
	}
	
	public void quack() {
		quacker.quack();
	}
}
