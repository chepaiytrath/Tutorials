import java.util.function.*;

public class LambdaDemo3 {
	public static void main(String[] args) {
		// Every LAMBDA is a first hand object.
		Consumer<String> expr1 = (String name) -> {
			System.out.println("Hello " + name);
			System.out.println("Bye " + name);
		}; 
		
		Consumer<String> expr2 = (String name) -> {
			System.out.println("Hello " + name);
			System.out.println("Bye " + name);
		}; 
		
		// LambdaDemo3$$Lambda$1/1418481495
		// Lambda 
		// Each LE is an object of Lambda : class - AnonymousInnerClass
		System.out.println(expr1.getClass().getName());
		System.out.println(expr2.getClass().getName());
		
		
		// DIFFERENCES WITH NORMAL METHODS
		
		// 1. Accessing method definition with dot operator
		// LAMBDA is an object : So it can be assigned via assignment operator to a Functional Interface OBJECT. Ex. Consumer
		// Right side of expr1/2 : method definition. But it is actually Lambda Object.
		// So expr1.abc() and expr2.abc() (dot operator) can be used on right side of this expression (method definition = Object)
		// Normal methods can't be accessed with . operator as they are not objects.
		
	
		// 2. NESTED FUNCTIONS 
		// Function call within function is possible 
		
		// 3. SCOPE :
		// Variable becomes final.
		
		
	}
	
}
