package com.jatin.code.practice.misc;

public class Multithreading {
	volatile int count = 0;

	public void increment() {
		count++;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Multithreading(int count) {
		super();
		this.count = count;
	}

	public static void main(String[] args) {
		Multithreading m = new Multithreading(0);
		System.out.println(m.getCount());
		m.increment();
		System.out.println(m.getCount());

	}

}
