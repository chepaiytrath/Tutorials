package designpattern.creational.builder.approach1;

public class NewComputerBuilder implements ComputerBuilder {
	private String os;
	private String processor;
	private String graphics;
	private int ram;
	private int hdd;

	@Override
	public ComputerBuilder buildOs(String os) {
		this.os = os;
		return this;
	}

	@Override
	public ComputerBuilder buildProcessor(String processor) {
		this.processor = processor;
		return this;
	}

	@Override
	public ComputerBuilder buildGraphics(String graphics) {
		this.graphics = graphics;
		return this;
	}

	@Override
	public ComputerBuilder buildRam(int ram) {
		this.ram = ram;
		return this;
	}

	@Override
	public ComputerBuilder buildHdd(int hdd) {
		this.hdd = hdd;
		return this;
	}

	@Override
	public Computer getComputer() {
		return new Computer(os, processor, graphics, ram, hdd);
	}

}
