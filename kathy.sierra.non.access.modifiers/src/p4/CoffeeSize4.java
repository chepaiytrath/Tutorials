package p4;

public enum CoffeeSize4 {
	BIG(8), HUGE(16), OVERWHELMING(32);
	
	private int quantity;

	private CoffeeSize4(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

}
