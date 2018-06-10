package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locks {
	private Lock lock = new ReentrantLock();
	private int x = 0;
	
	public void increment() {
		try{
			lock.lock();
			for(int i = 0; i < 10; i++) {
				x++;
			}
		}finally {
			lock.unlock();
		}
	}

	public void process() throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				increment();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				increment();
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	}
	
	public static void main(String[] args) {
		Locks l = new Locks();
		try {
			l.process();
			System.out.println(l.x);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
