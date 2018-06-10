package designpattern.builder.approach1;

public class NewComputerDirector implements ComputerDirector{
	private ComputerBuilder computerBuilder;

	public NewComputerDirector(ComputerBuilder computerBuilder) {
		super();
		this.computerBuilder = computerBuilder;
	}

	@Override
	public Computer buildComputerFromBuilder() {
		return computerBuilder.buildOs("windows").buildProcessor("intel")
		.buildGraphics("nvidia").buildRam(16).buildHdd(2048).getComputer();
	}
}
