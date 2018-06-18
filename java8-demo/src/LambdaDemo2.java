import java.util.function.*;

public class LambdaDemo2 {
	public static void main(String[] args) {
		Consumer<String> expr1 = (String name) -> {
			System.out.println("Hello " + name);
			System.out.println("Bye " + name);
		}; 
		
		//No datatpe is mandatory in args. Can give generic type.
		Consumer<String> expr2 = (name) -> {
			System.out.println("Hello " + name);
			System.out.println("Bye " + name);
		};
		
		//Can remove generics too along with arg datatype.
		Consumer expr3 = (name) -> {
			System.out.println("Hello " + name);
			System.out.println("Bye " + name);
		};
		
		//BUT if datatype mentioned for argument, generic datatype is mandatory
		
		
		
		
		///////////////////////////////////////////////////////////////////////
		// Other datatypes
		Consumer<Integer> expr4 = (Integer age) -> {
			System.out.println("Hello person with age" + age);
		}; 
		
		// Primitive datatype is not allowed at arg. Only use wrapper datatye.
		Consumer<Integer> expr5 = (int age) -> {
			System.out.println("Hello person with age " + name);
		}; 
		
		// Even removing generics doesn't help
		Consumer expr6 = (int name) -> {
			System.out.println("Hello person with age " + name);
		};
		
		
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
		Consumer expr10 = (a, b) -> {
			System.out.println("Hello ");
		}; 
		
		Consumer expr11 = () -> {
			System.out.println("Hello ");
		}; 
		
		// Can use some old interfaces as Functional Interfaces. Ex. Runnable
		Runnable expr12 = () -> {
			System.out.println("Hello ");
		};
		
		// Single line method definition can be defined without {}
		Consumer<String> expr13 = (name) -> System.out.println("Hello " + name);
		
		// Can remove () from argument level
		Consumer<String> expr14 = name -> System.out.println("Hello " + name);
		
		// Generic datatype is return datatype
		Supplier<Integer> expr15 = () -> {
			System.out.println("Calculating");
			return 10+20;
		};
		
		// Without generic datatype
		Supplier expr16 = () -> {
			System.out.println("Calculating");
			return 10+20;
		};
		
		// One LOC
		Supplier expr17 = () -> { return 10+20;	};
		
		// RETURN keyword is optional BUT remove curly braces.
		//Supplier expr18 = () ->  return 10+20;
		
		// Without return and ()
		Supplier expr19 = () ->  10+20;
		
		// Supplier generic datatype is for return type
		Supplier<Integer> expr20 = (Integer a) -> {
			System.out.println("Calculating");
			return 10+20;
		};
		
		// Use Function to cater above
		Function<Integer, Integer> expr21 = (Integer a) -> {
			System.out.println("Calculating");
			return 10+20;
		};
		
		// In case requirement is for multiple args, just create your own FI and use.
	}
	
}
