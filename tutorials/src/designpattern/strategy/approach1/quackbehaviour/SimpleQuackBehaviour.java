package designpattern.strategy.approach1.quackbehaviour;

public class SimpleQuackBehaviour implements IQuackBehaviour {

	@Override
	public void quack() {
		System.out.println("Quacks simply");
	}

}
