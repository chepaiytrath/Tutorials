package designpattern.creational.prototype.BO;

public class Animal implements Cloneable {
	private int age;

	public Animal getClone() throws CloneNotSupportedException {
		return (Animal) super.clone();
	}
}
