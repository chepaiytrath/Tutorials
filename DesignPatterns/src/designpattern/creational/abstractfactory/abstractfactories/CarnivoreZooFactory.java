package designpattern.creational.abstractfactory.abstractfactories;

import designpattern.creational.abstractfactory.BO.Animal;
import designpattern.creational.abstractfactory.BO.Hyena;
import designpattern.creational.abstractfactory.BO.Lion;

public class CarnivoreZooFactory implements ZooFactory {

	@Override
	public Animal animal1() {
		return new Lion();
	}

	@Override
	public Animal animal2() {
		return new Hyena();
	}

}
