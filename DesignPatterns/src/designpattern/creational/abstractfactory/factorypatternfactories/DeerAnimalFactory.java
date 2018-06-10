package designpattern.creational.abstractfactory.factorypatternfactories;

import designpattern.creational.abstractfactory.BO.Animal;
import designpattern.creational.abstractfactory.BO.Deer;

public class DeerAnimalFactory implements AnimalFactory{

	@Override
	public Animal createAnimal() {
		return new Deer();
	}

}
