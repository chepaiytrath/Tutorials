import java.util.function.*;

public class LambdaDemo {
	public static void main(String[] args) {
		new LambdaDemo();
		
	}

	public LambdaDemo() {
		//BP : rather than static, Lock on class level
		// display("Jatin");
		// If generics not used : Lambda expression's parameter name is expected to be of type Object
		// ; and Generics expected
		//Need to assign lambda expression to a datatype as with normal expressions.
		
		
		// Actual usage 
		Consumer<String> a = (String name) -> {
			System.out.println("Hello " + name);
			System.out.println("Bye " + name);
		};
		a.accept("Jatin");
	}

	private void display(String name) {
		System.out.println("Hello " + name);
	}
	
	//Lambda syntax/expression : () -> {}
	//Below is still not complete
	//	(String name) -> {
	//		System.out.println("Hello " + name);
	//	}
	
	
	// If generics not used : Lambda expression's parameter name is expected to be of type Object
	// ; and Generics expected
	//Need to assign lambda expression to a datatype as with normal expressions.
	Consumer<String> a = (String name) -> {
		System.out.println("Hello " + name);
		System.out.println("Bye " + name);
	};  // Use a.accept("Jatin") to invoke the LE
	
	// Above not to be confused with that the method return type should be the datatype of Lambda method expression. 
	// As I thought earlier.
	
}
