package p2;

public class Manager {
	private void method1() {
		Employee e1 = new Employee();
		e1.manager = "ANUPAM";
		System.out.println("manager1 = "+Employee.manager);
		
		Employee e2 = new Employee();
		e2.manager = "AMIT";
		System.out.println("manager2 = "+Employee.manager);
	}

	static final public void main(String[] args) {
		Manager m = new Manager();
		m.method1();
		Employee.method1(10);
	}
}
