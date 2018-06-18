package functionalinterfaces;

@FunctionalInterface
public interface CalFI {
	
	int sum(int x, int y);
	
	// Lambda expr is an implementation of interface
	// One method only : so that compiler isn't confused which method's implementation it is.
}
