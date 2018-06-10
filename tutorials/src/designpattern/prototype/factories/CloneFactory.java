package designpattern.prototype.factories;

import designpattern.prototype.BO.Animal;

public class CloneFactory {
	public Animal createAnimalClone(Animal animal) throws CloneNotSupportedException {
		return animal.getClone();
	}
}
