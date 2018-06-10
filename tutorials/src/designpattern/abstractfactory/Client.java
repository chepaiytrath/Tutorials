package designpattern.abstractfactory;

import designpattern.abstractfactory.BO.Animal;
import designpattern.abstractfactory.abstractfactories.HerbivoreZooFactory;
import designpattern.abstractfactory.abstractfactories.ZooFactory;
import designpattern.abstractfactory.factorypatternfactories.AnimalFactory;
import designpattern.abstractfactory.factorypatternfactories.CowAnimalFactory;

public class Client {
	public static void main(String[] args) {
		ZooFactory zooFactory = new HerbivoreZooFactory();		
		Animal animal1 = zooFactory.animal1();
		Animal animal2 = zooFactory.animal2();
		animal1.sound();
		animal2.sound();
		
		System.out.println();
		
		AnimalFactory animalFactory = new CowAnimalFactory();
		Animal animal = animalFactory.createAnimal();
		animal.sound();
	}
}
