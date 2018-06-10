package p8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsTest2 {
	public static void main(String[] args) {
		GenericsTest2 obj = new GenericsTest2();
		// obj.checkAnimals(animalArr);
		
		/*Animal[] animalArr = new Animal[3];
		animalArr[0] = new Dog();
		animalArr[1] = new Cat();
		animalArr[2] = new Bird();
		System.out.println(Arrays.asList(animalArr));*/

		Cat[] catArr = new Cat[4];
		catArr[0] = new Cat();
		catArr[1] = new Cat();
		catArr[2] = new Cat();
		obj.checkAnimals(catArr);
		System.out.println(Arrays.asList(catArr));

		/*List<Integer> myList = new ArrayList<Integer>();
		myList.add(4);
		myList.add(6);
		obj.insert(myList);
		System.out.println(myList);
		for(Object o : myList) {
			System.out.println(o.getClass().getName());
		}*/
		
		
		/*Animal[] arr = new Dog[3];
		arr[0] = new Cat();*/
		
	}

	void insert(List list) {
		list.add(new String("42")); // adds to the incoming list
	}

	public void checkAnimals(Animal[] animals) {
		for (int i = 0; i < 3; i++) {
			animals[i].checkup();
			animals[i] = new Dog();
		}
	}
}

abstract class Animal {
	public abstract void checkup();
}

class Dog extends Animal {
	public void checkup() { // implement Dog-specific code
		System.out.println("Dog checkup");
	}

	@Override
	public String toString() {
		return "Dog";
	}
}

class Cat extends Animal {
	public void checkup() { // implement Cat-specific code
		System.out.println("Cat checkup");
	}

	@Override
	public String toString() {
		return "Cat";
	}
}

class Bird extends Animal {
	public void checkup() { // implement Bird-specific code
		System.out.println("Bird checkup");
	}

	@Override
	public String toString() {
		return "Bird";
	}
}