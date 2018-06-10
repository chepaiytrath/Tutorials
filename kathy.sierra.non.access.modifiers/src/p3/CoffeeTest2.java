package p3;

class Coffee2{
	enum CoffeeSize2 {
		BIG, HUGE, OVERWHELMING
	}
	CoffeeSize2 size;
}

public class CoffeeTest2{
	private void method() {
		Coffee2 c = new Coffee2();
		c.size = Coffee2.CoffeeSize2.BIG;
	}
}
