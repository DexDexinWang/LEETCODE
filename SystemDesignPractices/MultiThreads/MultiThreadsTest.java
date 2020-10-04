
class ThreadTester extends Thread {
	private int id;

	public ThreadTester(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("inherited class : " + this.id);
	}
}

class ThreadTester2 implements Runnable {
	private int id;

	public ThreadTester2(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("runnable class : " + this.id);
	}
}

public class MultiThreadsTest {

	public static void main(String[] args) {
		System.out.println("------------Method 1 to create a thread------------");
		// Create Thread Method 1.
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(String.valueOf(i)) {
				@Override
				public void run() {
					System.out.println(getName());
				}
			};
			t.start(); // Any thread could be started once and only once.
			/*
			 * try { t.join(); } catch (InterruptedException e) { // TODO Auto-generated
			 * catch block e.printStackTrace(); }
			 */
		}

		System.out.println("------------Method 2 to create a thread------------");
		// Create Thread Method 2 with inherited class.
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(new ThreadTester(i));
			t.start();
		}

		System.out.println("------------Method 3 to create a thread------------");
		// Create Thread Method 3 with an interface because the some thread method may
		// be inherited another class.
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(new ThreadTester2(i));
			t.start();
		}
	}
}
