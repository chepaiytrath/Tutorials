package designpattern.creational.abstractfactory.abstractfactories;

import designpattern.creational.abstractfactory.BO.Animal;
import designpattern.creational.abstractfactory.BO.Cow;
import designpattern.creational.abstractfactory.BO.Deer;

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
