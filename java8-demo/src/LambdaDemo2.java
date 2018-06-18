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
		
		
	}
	
}
