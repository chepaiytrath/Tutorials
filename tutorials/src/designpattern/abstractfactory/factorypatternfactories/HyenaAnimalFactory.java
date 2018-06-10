package designpattern.abstractfactory.factorypatternfactories;

import designpattern.abstractfactory.BO.Animal;
import designpattern.abstractfactory.BO.Hyena;

public class HyenaAnimalFactory implements AnimalFactory{

	@Override
	public Animal createAnimal() {
		return new Hyena();
	}

}
