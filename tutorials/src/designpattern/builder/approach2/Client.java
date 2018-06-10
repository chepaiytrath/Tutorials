package designpattern.builder.approach2;

public class Client {
	public static void main(String[] args) {
		ComputerBuilder computerBuilder = new NewComputerBuilder();
		ComputerDirector computerDirector = new ComputerDirector(computerBuilder);
		System.out.println(computerDirector.buildComputerFromBuilder());
	}
}
