package designpattern.builder.approach2;

public interface ComputerBuilder {
	public void buildOs();
	public void buildProcessor();
	public void buildGraphics();
	public void buildRam();
	public void buildHdd();
	public Computer getComputer();
}
