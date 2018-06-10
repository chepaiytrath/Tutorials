package designpattern.prototype.BO;

public class Sheep extends Animal {
	private int age;
	
	public Sheep() {
		System.out.println("Sheep created");
	}

	public Sheep(int age) {
		this.age = age;
		System.out.println("Sheep created with age : "+age);
	}
	
	public Sheep getClone() throws CloneNotSupportedException {
		return (Sheep) super.clone();
	}

	@Override
	public String toString() {
		return "Sheep [age=" + age + "]";
	}

}
