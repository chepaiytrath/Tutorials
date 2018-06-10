package designpattern.abstractfactory.abstractfactories;

import designpattern.abstractfactory.BO.Animal;
import designpattern.abstractfactory.BO.Cow;
import designpattern.abstractfactory.BO.Deer;

public class HerbivoreZooFactory implements ZooFactory{

	@Override
	public Animal animal1() {
		return new Cow();
	}

	@Override
	public Animal animal2() {
		return new Deer();
	}

}
