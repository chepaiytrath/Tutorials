package multithreading;

public class WaitNotify {

	public void produce() throws InterruptedException {
		synchronized (this) {
			System.out.println("Producer");
			Thread.sleep(10000);
			wait();
			System.out.println("Again Producer");
		}
	}

	public void consume() throws InterruptedException {
		synchronized (this) {
			Thread.sleep(5000);
			System.out.println("Consumer");
			notify();
			System.out.println("Again Consumer");
		}
	}

	public static void main(String[] args) {
		WaitNotify obj = new WaitNotify();
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