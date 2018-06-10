package designpattern.builder.approach1;

public class Computer implements IComputer {
	private String os;
	private String processor;
	private String graphics;
	private int ram;
	private int hdd;

	public Computer(String os, String processor, String graphics, int ram, int hdd) {
		super();
		this.os = os;
		this.processor = processor;
		this.graphics = graphics;
		this.ram = ram;
		this.hdd = hdd;
	}

	public String getOs() {
		return os;
	}

	public String getProcessor() {
		return processor;
	}

	public String getGraphics() {
		return graphics;
	}

	public int getRam() {
		return ram;
	}

	
	public int getHdd() {
		return hdd;
	}

	@Override
	public void setOs(String os) {
		this.os = os;
	}

	@Override
	public void setProcessor(String processor) {
		this.processor = processor;
	}

	@Override
	public void setGraphics(String graphics) {
		this.graphics = graphics;
	}

	@Override
	public void setRam(int ram) {
		this.ram = ram;
	}

	@Override
	public void setHdd(int hdd) {
		this.hdd = hdd;
	}

	@Override
	public String toString() {
		return "Computer [os=" + os + ", processor=" + processor + ", graphics=" + graphics + ", ram=" + ram + ", hdd="
				+ hdd + "]";
	}

}
