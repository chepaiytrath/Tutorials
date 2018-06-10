package designpattern.builder.approach2;

public class NewComputerBuilder implements ComputerBuilder {
	private Computer computer;

	public NewComputerBuilder() {
		this.computer = new Computer();
	}

	@Override
	public void buildOs() {
		computer.setOs("Windows");
	}

	@Override
	public void buildProcessor() {
		computer.setProcessor("Intel");
	}

	@Override
	public void buildGraphics() {
		computer.setGraphics("nVidia");
	}

	@Override
	public void buildRam() {
		computer.setRam(16);
	}

	@Override
	public void buildHdd() {
		computer.setHdd(2018);
	}

	@Override
	public Computer getComputer() {
		return this.computer;
	}

}
