package designpattern.creational.prototype.factories;

import designpattern.creational.prototype.BO.Animal;

public class CloneFactory {
	public Animal createAnimalClone(Animal animal) throws CloneNotSupportedException {
		return animal.getClone();
	}
}
