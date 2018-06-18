import java.util.function.*;

public class LambdaDemo2 {
	public static void main(String[] args) {
		Consumer<String> expr1 = (String name) -> {
			System.out.println("Hello " + name);
			System.out.println("Bye " + name);
		}; 
		
		// No datatpe is mandatory in args. Can give generic type.
		Consumer<String> expr2 = (name) -> {
			System.out.println("Hello " + name);
			System.out.println("Bye " + name);
		};
		
		//Can remove generics too along with arg datatype.
		Consumer expr3 = (name) -> {
			System.out.println("Hello " + name);
			System.out.println("Bye " + name);
		};
		
		// BUT if datatype mentioned for argument, generic datatype is mandatory
		
		
		
		
		///////////////////////////////////////////////////////////////////////
		// Other datatypes
		Consumer<Integer> expr4 = (Integer age) -> {
			System.out.println("Hello person with age" + age);
		}; 
		
		// Primitive datatype is not allowed at arg. Only use wrapper datatye.
		//		Consumer<Integer> expr5 = (int age) -> {
		//			System.out.println("Hello person with age " + name);
		//		}; 
		
		// Even removing generics doesn't help
		//		Consumer expr6 = (int name) -> {
		//			System.out.println("Hello person with age " + name);
		//		};
		
		
		// Multiple args not allowed in Consumer functonal interface
		// Change FI to BiConsumer
		//Consumer<String, Integer> expr7 = (String name, Integer age) -> {
		BiConsumer<String, Integer> expr7 = (String name, Integer age) -> {
			System.out.println("Hello " + name);
			System.out.println("Hello person with age " + age);
		};
		
		// Can remove arg datatype as in Consumer FI
		BiConsumer<String, Integer> expr8 = (name, age) -> {
			System.out.println("Hello " + name);
			System.out.println("Hello person with age " + age);
		};
		
		// Can remove Generic datatype PLUS arg datatype as in Consumer FI
		BiConsumer expr9 = (name, age) -> {
			System.out.println("Hello " + name);
			System.out.println("Hello person with age " + age);
		};
		
		// If you want an API with multiple args, just create one by extending the ones provided
		
		
		// Consumer contract needs one argument at least. If none/multiple exist : incompatible type error
		// ERROR : Lambda expression's signature does not match the signature of the functional interface method accept(Object)
		//		Consumer expr10 = (a, b) -> {
		//			System.out.println("Hello ");
		//		}; 
		
		
		// Same error as above : 
		// Lambda expression's signature does not match the signature of the functional interface method accept(Object)
		//		Consumer expr11 = () -> {
		//			System.out.println("Hello ");
		//		}; 
		
		// Can use some old interfaces as Functional Interfaces. Ex. Runnable
		Runnable expr12 = () -> {
			System.out.println("Hello ");
		};
		
		// Single line method definition can be defined without {}
		Consumer<String> expr13 = (name) -> System.out.println("Hello " + name);
		
		// Can remove () from argument level
		Consumer<String> expr14 = name -> System.out.println("Hello " + name);
		
		
		
		//Supplier : To return some values. Which datatype of value : define in Generics
		// Generic datatype is return datatype
		Supplier<Integer> expr15 = () -> {
			System.out.println("Calculating");
			return 10+20;
		};
		
		// No return provided with Supplier LE throws error : This method must return a result of type Integer
		//		Supplier<Integer> expr16 = () -> {
		//			System.out.println("Calculating");
		//		};
		
		// Without generic datatype : Which datatype is returned doesn't matter
		Supplier expr17 = () -> {
			System.out.println("Calculating");
			return 'a';
		};
		
		// One LOC
		Supplier expr18 = () -> { return 10+20;	};
		
		// RETURN keyword is optional BUT if not present curly braces need to be removed.
		// Supplier expr18 = () ->  return 10+20;
		
		// Without return and ()
		Supplier expr19 = () ->  10+20;
		
		// Supplier generic datatype is for return type
		//		Supplier<Integer> expr20 = (Integer a) -> {
		//			System.out.println("Calculating");
		//			return 10+20;
		//		};
		
		// Use Function to cater above requirement of return type as well as argument.
		Function<Integer, Integer> expr20 = (Integer a) -> {
			System.out.println("Calculating");
			return 10+20;
		};
		
		// In case requirement is for more multiple args, just create your own FI and use.
		
		
		
		
		
		
		// Every LAMBDA is a first hand object.
		Consumer<String> exprX = (String name) -> {
			System.out.println("Hello " + name);
			System.out.println("Bye " + name);
		}; 
		
		Consumer<String> exprY = (String name) -> {
			System.out.println("Hello " + name);
			System.out.println("Bye " + name);
		}; 
		
		// LambdaDemo2$$Lambda$16/558638686
		// LambdaDemo2$$Lambda$17/1149319664
		// Each LE is an object of Lambda : class - AnonymousInnerClass
		
		//For each LE, Anonymous Inner Class of Lambda type is created : 
		// AIC : Lambda$16, Lambda$17 created inside the class file.
		// A separate $class is not created as in the case ofregular AIC
		System.out.println(exprX.getClass().getName());
		System.out.println(exprY.getClass().getName());
		
		
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
