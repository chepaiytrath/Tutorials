package designpattern.creational.abstractfactory.factorypatternfactories;

import designpattern.creational.abstractfactory.BO.Animal;
import designpattern.creational.abstractfactory.BO.Hyena;

public class HyenaAnimalFactory implements AnimalFactory{

	@Override
	public Animal createAnimal() {
		return new Hyena();
	}

}
