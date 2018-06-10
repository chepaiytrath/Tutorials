package designpattern.creational.builder.approach2;

public class ComputerDirector {
	
	private ComputerBuilder computerBuilder;

	public ComputerDirector(ComputerBuilder computerBuilder) {
		super();
		this.computerBuilder = computerBuilder;
	}

	public Computer buildComputerFromBuilder() {
		computerBuilder.buildOs();
		computerBuilder.buildProcessor();
		computerBuilder.buildGraphics();
		computerBuilder.buildRam();
		computerBuilder.buildHdd();
		return computerBuilder.getComputer();
	}
}
