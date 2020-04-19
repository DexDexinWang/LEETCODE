
public class BoundedQueue {
	public int left = 0;
	public int right = 0;
	public int size = 0;
	public Integer[] array;
	 	public BoundedQueue(int capacity) 
	    {
	 		array = new Integer[capacity];
	    }
	    
	    /** Push element x to the back of queue. */
	    public void offer(int x) 
	    {
	        if(size == array.length) {
	        	new Exception("The Bounded Queue is full.");
	        } else {
	        	array[right] = x;
	        	right = (right + 1) % (array.length - 1); 
	        	size++;
	        }
	    }
	    
	    /** Removes the element from in front of queue and returns that element. */
	    public Integer poll() 
	    {
	        if(empty()) {
	        	return null;
	        } else {
	        	Integer temp = array[left];
	        	left = (left + 1) % (array.length - 1);
	        	size--;
	        	return temp;
	        }
	    }
	    
	    /** Get the front element. */
	    public Integer peek() 
	    {
	    	if (empty()) {
	    		return null;
	    	}
	        return array[left];
	    }
	    
	    /** Returns whether the queue is empty. */
	    public boolean empty() 
	    {
	        return size == 0;
	    }
}
