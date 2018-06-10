package p7;

import java.lang.reflect.Method;

public class StaticTest {
	static String s1 = "static1";
	String s2 = "nonstatic1";
	
	private void method1() {
		s1 += "23";
		s2 += "23";
		
		method2();
	}
	
	private static void method2() {
		s1 += "23";
		s2 += "23";
		
		method1();
	}
	
	public static void main(String[] args) {
		method();
		s1 = s1 + "23";
		s2 = s2 + "23";
	}
	
	
}
