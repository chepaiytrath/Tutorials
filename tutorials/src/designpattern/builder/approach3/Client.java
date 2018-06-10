package designpattern.builder.approach3;

// Same approach used in lombok
public class Client {
	public static void main(String[] args) {
		ComputerDirector computerDirector = new ComputerDirector();
		System.out.println(computerDirector.buildComputerFromBuilder());
	}
}