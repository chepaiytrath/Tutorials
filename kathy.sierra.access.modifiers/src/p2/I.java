package p2;

import p1.F;

public class I extends F {
	private void method1() {
		int x;
		x = a;
		x = b;
		x = c;
		x = d;
		
		F objF = new F();
		x = objF.a;
		x = objF.b; //Not referencable
		x = objF.c;
		x = objF.d;
	}
}
