package multithreading;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {
	List<Integer> list = new ArrayList<>();
	private final int TOP = 5;
	private final int BOTTOM = 0;
	private final Object lock = new Object();
	private int value = 0;
	
	public void produce() throws InterruptedException {
		synchronized (lock) {
			while(true) {
				while(list.size() == TOP) {
					System.out.println("List full. Waiting.");
					lock.wait();
				}
				System.out.println("Adding : " + value);
				list.add(value++);
				lock.notify();
				
				Thread.sleep(500);
			}
		}
	}

	public void consume() throws InterruptedException {
		synchronized (lock) {
			while(true) {
				while(list.size() == BOTTOM) {
					System.out.println("List empty. Waiting.");
					lock.wait();
				}
				System.out.println("Removing : " + (value - 1));
				list.remove(--value);
				lock.notify();
				Thread.sleep(500);
			}
		}
	}

	public static void main(String[] args) {
		ProducerConsumer obj = new ProducerConsumer();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					obj.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					obj.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}