
public class DaemonThread extends Thread {

	public DaemonThread(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		if(Thread.currentThread().isDaemon()) {
			System.out.println(this.getName() + " is a daemon thread!");
		} else {
			System.out.println(this.getName() + " is a user thread!");
		}
	}
	
	public static void main(String[] args) {

		DaemonThread t1 = new DaemonThread("t1"); 
        DaemonThread t2 = new DaemonThread("t2"); 
        DaemonThread t3 = new DaemonThread("t3"); 
      
        // Setting user thread t1 to Daemon 
        t1.setDaemon(true); 
              
        // starting first 2 threads  
        t1.start();  
        //setDaemon() cannot be called when the thread is started. otherwise, java.lang.IllegalThreadStateException
        //t1.setDaemon(true);  
        t2.start(); 
  
        // Setting user thread t3 to Daemon 
        t3.setDaemon(true);  
        t3.start();   
	}
}
