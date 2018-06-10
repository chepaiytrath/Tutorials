package designpattern.strategy.approach1.quackbehaviour;

public class NoQuackBehaviour implements IQuackBehaviour {

	@Override
	public void quack() {
		System.out.println("Doesn't quack");
	}

}
