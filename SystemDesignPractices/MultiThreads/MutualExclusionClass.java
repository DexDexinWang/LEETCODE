


public class MutualExclusionClass {

	class Counter{
		private int value;
		public Counter(int value) {
			this.value = value;
		}
		
		public void increase() {
			//Mutual exclusion for critical section. 
			synchronized(this) { //synchronized should be work for object.
				value++;
			}
			//...
			//others are not locked.
		}
		
		//Mutual exclusion for method. 
		public synchronized void decrease() {
			value--;
		}
		
		public synchronized int getCount() {
			return value;
		}
	}
	
	static class StaticCounter{
		private  static int value;
		
		public static void increase() {
			//Mutual exclusion for critical section. 
			synchronized(Counter.class) { //synchronized should be work for static class.
				value++;
			}
			//...
			//others are not locked.
		}
		
		//synchronize method means synchronize class
		public static  void decrease() {
			synchronized(Counter.class) {
				value--;
			}
		}
		
		public int getCount() {
			synchronized(Counter.class) {
				return value;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
