
public class VolatileExample {

	public static volatile boolean flag = false; // volatile will avoid infinity loop for Java compile to do
													// optimization.

	public static class MyRunnable implements Runnable {
		@Override
		public void run() {
			while (!flag) {
				System.out.println("The thread is running.");
			}
			System.out.println("The thread is finished.");
		}
	}

	public static void main(String[] args) {
		Thread t = new Thread(new MyRunnable());
		t.start();
		try {
			t.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		flag = true; // Will pass signal between threads and that will create alive locks.
		System.out.println("Main thread is finished.");
	}

	/*
	 * Atomicity of value++ is not preserved! volatile int value = 0; thread 1:
	 * value++; // read * 10x slower, write * 70x slower
	 * 
	 * thread 2: value++;
	 * 
	 * value ==2 ?
	 * 
	 * Because volatile can only guarantee single read/write operation is atomic.
	 * Bottom line: read only or write only use cases are fine. if there a
	 * read-then-update case, if you really need atomicity for value++, check
	 * AtomicInteger/AtomicLong classes. However, they are expensive. Use it only if
	 * you really know why you need it.
	 */
}
