package designpattern.abstractfactory.factorypatternfactories;

import designpattern.abstractfactory.BO.Animal;
import designpattern.abstractfactory.BO.Lion;

public class LionAnimalFactory implements AnimalFactory{

	@Override
	public Animal createAnimal() {
		return new Lion();
	}

}
