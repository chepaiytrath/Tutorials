package designpattern.creational.factorymethod;

public class DogAnimalFactory implements AnimalFactory{

	@Override
	public Animal createAnimal() {
		return new Dog();
	}

}
