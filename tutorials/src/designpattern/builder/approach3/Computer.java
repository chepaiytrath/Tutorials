package designpattern.builder.approach3;

public class Computer implements IComputer {
	private String os;
	private String processor;
	private String graphics;
	private int ram;
	private int hdd;

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

	public static ComputerBuilder builder() {

		return new ComputerBuilder();

	}

	public static class ComputerBuilder {
		private String os;
		private String processor;
		private String graphics;
		private int ram;
		private int hdd;

		public ComputerBuilder buildOs(String os) {
			this.os = os;
			return this;
		}

		public ComputerBuilder buildProcessor(String processor) {
			this.processor = processor;
			return this;
		}

		public ComputerBuilder buildGraphics(String graphics) {
			this.graphics = graphics;
			return this;
		}

		public ComputerBuilder buildRam(int ram) {
			this.ram = ram;
			return this;
		}

		public ComputerBuilder buildHdd(int hdd) {
			this.hdd = hdd;
			return this;
		}

		public Computer getComputer() {
			Computer computer = new Computer();
			computer.setGraphics(this.graphics);
			computer.setHdd(this.hdd);
			computer.setOs(this.os);
			computer.setProcessor(this.processor);
			computer.setRam(this.ram);
			return computer;
		}

	}
}
