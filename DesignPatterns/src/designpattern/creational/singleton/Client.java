package designpattern.creational.singleton;

class Client {
	public static void main(String[] args) {
		Module1ServiceFactory factory = Module1ServiceFactoryImpl.getInstance();
		ComponentA compA = factory.getComponentA();
		compA.printComponentA();
		
		ComponentB compB = factory.getComponentB();
		compB.printComponentB();
	}
}

class Module1ServiceFactoryImpl implements Module1ServiceFactory {
	private static Module1ServiceFactory instance;

	private Module1ServiceFactoryImpl() {
	}

	public static synchronized Module1ServiceFactory getInstance() {
		if (null == instance) {
			instance = new Module1ServiceFactoryImpl();
		}

		return instance;
	}

	public ComponentA getComponentA() {
		ComponentA componentA = new ComponentAImpl();
		ComponentB componentB = getComponentB();
		componentA.setComponentB(componentB);
		return componentA;
	}

	public ComponentB getComponentB() {
		return new ComponentBImpl();
	}
}

interface Module1ServiceFactory {
	ComponentA getComponentA();

	ComponentB getComponentB();
}

interface ComponentA {
	void setComponentB(ComponentB componentB);

	void printComponentA();
}

class ComponentAImpl implements ComponentA {
	ComponentB componentB;

	@Override
	public void setComponentB(ComponentB componentB) {
		this.componentB = componentB;
	}

	@Override
	public void printComponentA() {
		System.out.println("ComponentA");
	}
}

interface ComponentB {
	public void printComponentB();
}

class ComponentBImpl implements ComponentB {
	@Override
	public void printComponentB() {
		System.out.println("ComponentB");
	}
}
