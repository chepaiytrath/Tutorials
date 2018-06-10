package designpattern.builder.approach3;

public class ComputerDirector {

	public Computer buildComputerFromBuilder() {
		return Computer.builder()
				.buildGraphics("nVidia")
				.buildHdd(2048)
				.buildOs("Windows")
				.buildProcessor("Intel")
				.buildRam(16)
				.getComputer();
	}
}
