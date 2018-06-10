package p9;

import java.util.ArrayList;
import java.util.List;

public class GenericListTest {
	public static void main(String[] args) {
		Animal[] dogArr = new Dog[3];
		dogArr[0] = new Dog();
		dogArr[1] = new Dog();
		dogArr[2] = new Dog();
		//checkAnimalsArr(dogArr);

		// List<Animal> dogList = new ArrayList<Dog>();

		List<Dog> dogList2 = new ArrayList<Dog>();
		dogList2.add(new Dog());
		dogList2.add(new Dog());
		// checkAnimalsList(dogList2);

		//checkAnimalsListExtendsWildcard(dogList2);
		checkAnimalsListSuperWildcard(dogList2);
	}

	public static void checkAnimalsArr(Animal[] animals) {
		for (int i = 0; i < animals.length; i++) {
			animals[i].checkup();
		}
	}

	public static void checkAnimalsList(List<Animal> animals) {
		for (int i = 0; i < animals.size(); i++) {
			animals.get(i).checkup();
		}
	}

	public static void addAnimalsArr(Animal[] animals) {
		for (int i = 0; i < animals.length; i++) {
			animals[i] = new Cat();
		}
	}

	public static void addAnimalsList(List<Animal> animals) {
		animals.add(new Cat());
	}

	public static void checkAnimalsListExtendsWildcard(List<? extends Animal> animals) {
		for (int i = 0; i < animals.size(); i++) {
			animals.get(i).checkup();
		}
		// animals.add(new Cat());
	}

	public static void checkAnimalsListSuperWildcard(List<? super Dog> dogs) {
		for (int i = 0; i < dogs.size(); i++) {
			((Dog) dogs.get(i)).checkup();
		}
		dogs.add(new Dog());
	}
}

abstract class Animal {
	public abstract void checkup();
}

class Dog extends Animal {
	public void checkup() { // implement Dog-specific code
		System.out.println("Dog checkup");
	}
}

class Cat extends Animal {
	public void checkup() { // implement Cat-specific code
		System.out.println("Cat checkup");
	}
}

class Bird extends Animal {
	public void checkup() { // implement Bird-specific code
		System.out.println("Bird checkup");
	}
}