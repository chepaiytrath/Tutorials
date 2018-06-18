package functionalinterfaces;

public class Main {
	public static void main(String[] args) {
		// oldWays : Impl, AIC
		oldWayAIC();
		oldWayImpl();

		
		newWay();
		
		
			
		testOne();
		testTwo();
		testThree();
	}

	public static void testOne() {
		Math math = new Math() {
			public int calculate(int x, int y) {
				return x+y;
			}
		};
		doCalculate("ABC", math);
	}
	
	public static void testTwo() {
		Math math = (x, y) -> x+y;
		doCalculate("DEF", math);
	}
	
	public static void testThree() {
		// CAN PASS LE AS METHOD PARAMETER
		
		
		//(x, y) -> x+y : Syntax is correct, can be passed to method 
		// This follows the RULE : NO VARIABLE TO REFER TO LE
		// LAMBDAs are not supposed to be reusable.
		
		
		//Steps : 
		// 1. Check if it is LE
		// 2. Check if doCalculate has second argument as a functional interface and the method in FI matches this LE implementation
		doCalculate("GHI", (x, y) -> x+y);
		doCalculate("JKL", (x, y) -> x-y);
		doCalculate("MNO", (x, y) -> x*y);
		doCalculate("PQR", (x, y) -> x/y);
		
		// Now, the LE at (x, y) -> x+y cannot be reused : RULE SATISFIED
	}
	
	public static void doCalculate(String name, Math math){
		System.out.println("Hi : "+name);
		math.calculate(20, 5);
	}
	
	static void newWay() {
		// Signature of interface : signature of only method in interface. Name and scope doesn't matter
		// Only return type and arguments do
		CalFI cal = (a, b) -> {
			return a + b;
		};
		System.out.println(cal.sum(10, 10));
	}
	
	// LAMBDAs are not supposed to be reusable.
	static void newWayMultipleImpls() {
		Math sum = (a, b) -> a + b;
		Math diff = (a, b) -> a - b;
		Math product = (a, b) -> a * b;
		Math divide = (a, b) -> a / b;
		
		System.out.println(sum.calculate(20, 5));
		System.out.println(diff.calculate(20, 5));
		System.out.println(product.calculate(20, 5));
		System.out.println(divide.calculate(20, 5));
		
		// Still able to reuse sum.calculate : Which is against the RULE above.
		// LAMBDAs are not supposed to be reusable.
	}
	
	static void oldWayAIC() {
		CalFI cal = new CalFI() {

			@Override
			public int sum(int x, int y) {
				return x + y;
			}
		};

		System.out.println(cal.sum(10, 10));
	}

	static void oldWayImpl() {
		CalFI cal = new CalFIImpl();
		System.out.println(cal.sum(10, 10));
	}
}