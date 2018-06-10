package designpattern.creational.factorymethod;

public class CatAnimalFactory implements AnimalFactory{

	@Override
	public Animal createAnimal() {
		return new Cat();
	}

}
