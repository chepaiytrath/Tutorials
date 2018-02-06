package com.jatin.code.practice.misc;

import java.util.ArrayList;
import java.util.List;

public class Generics {
	public static void main(String[] args) {
		/*// ?
		List<?> list0 = new ArrayList<Object>();
		List<?> list1 = new ArrayList<Pet>();
		List<?> list2 = new ArrayList<Dog>();
		List<?> list3 = new ArrayList<Husky>();
		
		
		// ? extends : 
		//List<? extends Pet> list4 = new ArrayList<Object>();
		List<? extends Pet> list5 = new ArrayList<Pet>();
		List<? extends Pet> list6 = new ArrayList<Dog>();
		List<? extends Pet> list7 = new ArrayList<Husky>();
		
		//List<? extends Dog> list8 = new ArrayList<Object>();
		//List<? extends Dog> list9 = new ArrayList<Pet>();
		List<? extends Dog> list10 = new ArrayList<Dog>();
		List<? extends Dog> list11 = new ArrayList<Husky>();
		
		//List<? extends Husky> list12 = new ArrayList<Object>();
		//List<? extends Husky> list13 = new ArrayList<Pet>();
		//List<? extends Husky> list14 = new ArrayList<Dog>();
		List<? extends Husky> list15 = new ArrayList<Husky>();
		
		
		// ? super : 
		List<? super Pet> list16 = new ArrayList<Object>();
		List<? super Pet> list17 = new ArrayList<Pet>();
		//List<? super Pet> list18 = new ArrayList<Dog>();
		//List<? super Pet> list19 = new ArrayList<Husky>();
		
		List<? super Dog> list20 = new ArrayList<Object>();
		List<? super Dog> list21 = new ArrayList<Pet>();
		List<? super Dog> list22 = new ArrayList<Dog>();
		//List<? super Dog> list23 = new ArrayList<Husky>();
		
		List<? super Husky> list24 = new ArrayList<Object>();
		List<? super Husky> list25 = new ArrayList<Pet>();
		List<? super Husky> list26 = new ArrayList<Dog>();
		List<? super Husky> list27 = new ArrayList<Husky>();
		
		//list16.add(new Object());
		list16.add(new Pet());
		list16.add(new Dog());
		list16.add(new Husky());
		
		//list17.add(new Object());
		list17.add(new Pet());
		list17.add(new Dog());
		list17.add(new Husky());
		
		//list20.add(new Object());
		//list20.add(new Pet());
		list20.add(new Dog());
		list20.add(new Husky());
		
		//list21.add(new Object());
		//list21.add(new Pet());
		list21.add(new Dog());
		list21.add(new Husky());
		
		//list22.add(new Object());
		//list22.add(new Pet());
		list22.add(new Dog());
		list22.add(new Husky());
		
		//list24.add(new Object());
		//list24.add(new Pet());
		//list24.add(new Dog());
		list24.add(new Husky());
		
		
		List<? extends B> list50 = new ArrayList<H>();
		
		List<? super B> list51 = new ArrayList<A>();
		list51.add(new H());
		
		
		
		
		
		*/
		
		
		B b = new C();
	}
}
 

class Pet {
	void method1() {

	}
}

class Dog extends Pet {
	@Override
	void method1() {

	}
}

class Husky extends Dog {

}

class A{
	protected int a = 5;
	void method1() {
		System.out.println("A");
	}
	int incValue() {
		int a = 10;
		System.out.println("new value = "+a);
		return a;
	}
	int getA() {
		return a;
	}
	A(){
		System.out.println("A Constructor");
	}
}
class X{
	X(){
		System.out.println("X Constructor");
		A a = new A();
		a.a = 20;
	}
	
}
class B extends A{
	/*B(){
		System.out.println("B constructor");
	}*/
	void method1() {
		System.out.println("B");
	}
	void method2() {
		System.out.println("B");
	}
}
class C extends B{
	void method1() {
		System.out.println("C");
	}
	C(){
		System.out.println("C Constructor");
		System.out.println("C Resumes");
	}
}
class D extends B{
	void method1() {
		System.out.println("D");
	}
}
class E extends B{
	void method1() {
		System.out.println("E");
	}
}
class F extends D{
	void method1() {
		System.out.println("F");
	}
}
class G extends E{
	void method1() {
		System.out.println("G");
	}
	
	static void method3() {
		System.out.println("G static method3");
	}
}
class H extends G{
	void method1() {
		System.out.println("H");
	}
	static void method3() {
		System.out.println("H static method3");
	}
}