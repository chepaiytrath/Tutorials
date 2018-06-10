package p7;

public class CastingTest {
	CastingTest ct;
	public static void main(String[] args) {
		CastingTest ct = null;
		ct.method();
		int x;
		
		x = 0;
		System.out.println(x);
		int a = 27;
		byte b = (byte) 2.1;	
		System.out.println(b);
		
		
		
		float f = 234.56f;
		short s = (short) f;
		System.out.println(s);
		
		b += 7;
		System.out.println(b);
	}
	
	private void method() {
		ct.method();
	}
}
