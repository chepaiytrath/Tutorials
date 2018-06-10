package p2;

public class Employee {
	// define fields (instance variables) for employee instances
	private final transient String name = "JATIN";
	//synchronized String title;
	public static String manager = "RAVINDER";
	// other code goes here including access methods for private
	// fields
	
	public static void method1(final int i) {
		String x = manager;
		System.out.println(x);
	}
}
