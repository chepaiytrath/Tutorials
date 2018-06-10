package designpattern.creational.factorymethod;

public class Client {
	public static void main(String[] args) {
		AnimalFactory factory = new DogAnimalFactory();
		Animal animal = factory.createAnimal();
		animal.sound();
		
		factory = new CatAnimalFactory();
		animal = factory.createAnimal();
		animal.sound();
	}
}
