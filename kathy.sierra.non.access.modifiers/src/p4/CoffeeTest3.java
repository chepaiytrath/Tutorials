package p4;

import p3.Coffee3;

public class CoffeeTest3 {
	private void method() {
		Coffee3 c = new Coffee3();
		c.size = Coffee3.CoffeeSize3.BIG;
		System.out.println(c.size);
	}
	
	public static void main(String[] args) {
		CoffeeTest3 ct3 = new CoffeeTest3();
		ct3.method();
	}
}