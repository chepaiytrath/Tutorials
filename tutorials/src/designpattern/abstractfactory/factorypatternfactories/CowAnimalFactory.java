package designpattern.abstractfactory.factorypatternfactories;

import designpattern.abstractfactory.BO.Animal;
import designpattern.abstractfactory.BO.Cow;

public class CowAnimalFactory implements AnimalFactory{

	@Override
	public Animal createAnimal() {
		return new Cow();
	}

}
