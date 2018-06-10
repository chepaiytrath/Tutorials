package multithreading;

public class Synchronized {
	private static Integer counter;
	Object lock = new Object();
	
	public Synchronized() {
		counter = 0;
	}

	public void increment() {
		
		synchronized(lock) {
			++counter;
		}
	}
	
	public void process() {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					increment();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					increment();
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

	public static void main(String[] args) {
		Synchronized s = new Synchronized();
		s.process();
		System.out.println(counter);
	}
}
