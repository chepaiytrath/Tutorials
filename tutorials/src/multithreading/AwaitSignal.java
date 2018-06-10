package multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AwaitSignal {
	private static Lock lock = new ReentrantLock();
	private static Condition condition = lock.newCondition();
	
	//private static Object lock = new Object();

	private static void method1() throws InterruptedException {
		//synchronized (lock) {
		lock.lock();
		System.out.println("method1 starts");
		//lock.wait();
		condition.await();
		System.out.println("method1 ends");
		lock.unlock();
		//}
	}

	private static void method2() throws InterruptedException {
		Thread.sleep(3000);
		//synchronized (lock) {
		lock.lock();		
		System.out.println("method2 starts");
		//lock.notify();
		condition.signal();
		System.out.println("between await and signal in method 2");
		//lock.wait();
		condition.await();
		System.out.println("method2 ends");
		Thread.sleep(3000);
		//}
	}

	public static void main(String[] args) {
		System.out.println("main thread started");
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					method1();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "t1");

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					method2();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, "t2");

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main thread ended");
	}
}