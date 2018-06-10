package p3;

enum CoffeeSize {
	BIG, HUGE, OVERWHELMING
}

class Coffee{
	CoffeeSize size;
}

public class CoffeeTest{
	private void method() {
		Coffee c = new Coffee();
		c.size = CoffeeSize.BIG;
	}
}
