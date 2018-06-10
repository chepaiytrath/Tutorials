package multithreading;

public class Sleep {
	public void method1() throws InterruptedException {
		System.out.println("method1");
		Thread.yield();
		System.out.println("method1 resumes");
	}
	
	public void method2() {
		System.out.println("method2");
	}
	
	public static void main(String[] args) {
		Sleep s = new Sleep();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					s.method1();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				s.method2();				
			}
		});
		
		Thread t3 = new Thread(new Runnable() {
			public void run() {
				try {
					s.method1();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t4 = new Thread(new Runnable() {
			public void run() {
				s.method2();				
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
