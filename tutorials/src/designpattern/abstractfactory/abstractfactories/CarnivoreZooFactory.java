package designpattern.abstractfactory.abstractfactories;

import designpattern.abstractfactory.BO.Animal;
import designpattern.abstractfactory.BO.Hyena;
import designpattern.abstractfactory.BO.Lion;

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
