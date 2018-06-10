package designpattern.abstractfactory.factorypatternfactories;

import designpattern.abstractfactory.BO.Animal;
import designpattern.abstractfactory.BO.Deer;

public class DeerAnimalFactory implements AnimalFactory{

	@Override
	public Animal createAnimal() {
		return new Deer();
	}

}
