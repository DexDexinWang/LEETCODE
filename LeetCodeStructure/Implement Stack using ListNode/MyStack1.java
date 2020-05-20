import generator.ListNode;

public class MyStack1 {
	public ListNode head; 
	public MyStack1() 
    {
		head = null;
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) 
    {
    	ListNode newNode = new ListNode(x);
    	if(head == null) {
    		head = newNode;
    	} else {
    		newNode.next = head;
    		head = newNode;
    	}
    	
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public Integer pop() 
    {
        if(head == null) {
        	return null;
        } else {
        	ListNode temp = head;
        	head = head.next;
        	temp.next = null;
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
