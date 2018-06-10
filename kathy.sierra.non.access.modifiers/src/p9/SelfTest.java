package p9;

import java.util.ArrayList;
import java.util.List;

public class SelfTest {
	public static void main(String[] args) {
		List<List<Integer>> table = new ArrayList<List<Integer>>();
		Integer x = Integer.valueOf(0);
		System.out.println(x);
		
		B obj = new B() {

			@Override
			public void method1() {
				// TODO Auto-generated method stub
				
			}
		};
	}
}

interface A {
	void method1();
}

abstract class B implements A {

}

interface Hungry<E> {
	void munch(E x);
}

interface Carnivore<E extends Animal3> extends Hungry<E> {
}

interface Herbivore<E extends Plant> extends Hungry<E> {
}

abstract class Plant {
}

class Grass extends Plant {
}

abstract class Animal3 {
}

class Sheep extends Animal3 implements Herbivore<Sheep> {
	public void munch(Sheep x) {
	}
}

class Wolf extends Animal3 implements Herbivore<Grass> {
	public void munch(Grass x) {
	}
}
