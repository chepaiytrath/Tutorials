package designpattern.creational.abstractfactory.factorypatternfactories;

import designpattern.creational.abstractfactory.BO.Animal;
import designpattern.creational.abstractfactory.BO.Lion;

public class LionAnimalFactory implements AnimalFactory{

	@Override
	public Animal createAnimal() {
		return new Lion();
	}

}
