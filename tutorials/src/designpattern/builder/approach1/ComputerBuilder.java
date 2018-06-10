package designpattern.builder.approach1;

public interface ComputerBuilder {
	public ComputerBuilder buildOs(String os);
	public ComputerBuilder buildProcessor(String processor);
	public ComputerBuilder buildGraphics(String graphics);
	public ComputerBuilder buildRam(int ram);
	public ComputerBuilder buildHdd(int hdd);
	public Computer getComputer();
}
