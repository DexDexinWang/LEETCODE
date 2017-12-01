/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on May 29, 2017 10:06:15 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */


/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

import java.util.Queue;
import java.util.LinkedList;

public class MyStack {
	private Queue<Integer> q1 = new LinkedList<Integer>();
	private Queue<Integer> q2 = new LinkedList<Integer>();
    /** Initialize your data structure here. */
    public MyStack() {}
    
    /** Push element x onto stack. */
    public void push(int x) 
    {
    	if(!q1.isEmpty()) 
    	{
    		q1.add(x);
    	}
    	else 
    	{
    		q2.add(x);
    	}
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() 
    {
    	if(q1.isEmpty())
    	{
    		int size = q2.size();
    		for(int i=1; i<size; i++)
    		{
    			q1.add(q2.poll());
    		}
    		return q2.poll();
    	}
    	else
    	{
    		int size = q1.size();
    		for(int i=1; i<size; i++)
    		{
    			q2.add(q1.poll());
    		}
    		return q1.poll();
    	}
    }
    
    /** Get the top element. */
    public int top() 
    {
        int res;
        if(q1.isEmpty())
    	{
    		int size = q2.size();
    		for(int i=1; i<size; i++)
    		{
    			q1.add(q2.poll());
    		}
    		res =q2.poll();
    		q1.add(res);
    	}
    	else
    	{
    		int size = q1.size();
    		for(int i=1; i<size; i++)
    		{
    			q2.add(q1.poll());
    		}
    		res =q1.poll();
    		q2.add(res); 
    	}
        return res;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
