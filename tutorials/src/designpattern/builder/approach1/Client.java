package designpattern.builder.approach1;

public class Client {
	public static void main(String[] args) {
		ComputerBuilder computerBuilder = new NewComputerBuilder();
		ComputerDirector computerDirector = new NewComputerDirector(computerBuilder);
		System.out.println(computerDirector.buildComputerFromBuilder());
	}
}