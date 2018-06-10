package designpattern.facade;

public class Client {
	public static void main(String[] args) {
		/*Interface1 obj = new A();
		System.out.println(obj.getProp());
		
		obj = new B();
		System.out.println(obj.getProp());*/
		
		
		Facade facade = new Facade();
		//System.out.println(facade.getInterface2("B1").hashCode());
		//System.out.println(facade.getInterface2("B1").hashCode());
		
		System.out.println(facade.getA1().hashCode());
		System.out.println(facade.getA1().hashCode());
		
		System.out.println(facade.operateOnA1B1Values());
	}
}
