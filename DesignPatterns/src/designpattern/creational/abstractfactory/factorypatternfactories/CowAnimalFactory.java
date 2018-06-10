package designpattern.creational.abstractfactory.factorypatternfactories;

import designpattern.creational.abstractfactory.BO.Animal;
import designpattern.creational.abstractfactory.BO.Cow;

public class CowAnimalFactory implements AnimalFactory{

	@Override
	public Animal createAnimal() {
		return new Cow();
	}

}
