import generator.ListNode;
public class MyQueue1 {

		ListNode head = null;
		ListNode tail = null;
		
	    /** Initialize your data structure here. */
	    public MyQueue1() 
	    {
	    	
	    }
	    
	    /** Push element x to the back of queue. */
	    public void offer(int x) 
	    {
	    	ListNode newNode = new ListNode();
	        if (head == null) {
	        	head = newNode;
	        	tail = newNode;
	        } else {
	        	tail.next = newNode;
	        	tail = tail.next;
	        }
	    }
	    
	    /** Removes the element from in front of queue and returns that element. */
	    public Integer poll() 
	    {
	        if (head == null) {
	        	return null;
	        } else {
	        	ListNode temp = head;
	        	head = head.next;
	        	temp.next = null;
	        	if (temp == tail) {
	        		tail = null;
	        	}
	        	return temp.val;
	        }
	    }
	    
	    /** Get the front element. */
	    public Integer peek() 
	    {
	        if (head == null) {
	        	return null;
	        } else {
	        	return head.val;
	        }
	    }
	    
	    /** Returns whether the queue is empty. */
	    public boolean empty() 
	    {
	        return head == null;
	    }
	}

