package p4;
class Coffee{
	CoffeeSize4 size;
}

public class CoffeeTest4 {
	public static void main(String[] args) {
		Coffee c = new Coffee();
		c.size = CoffeeSize4.OVERWHELMING;
		System.out.println(c.size.getQuantity());
		
		for(CoffeeSize4 cs4 : CoffeeSize4.values()){
			System.out.println(cs4.getQuantity());
		}
	}
}
