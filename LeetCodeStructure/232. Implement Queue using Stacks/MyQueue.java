/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on May 29, 2017 9:04:03 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */


/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
import java.util.Stack;
public class MyQueue {
	Stack<Integer> pushStack = new Stack<Integer>();
	Stack<Integer> popStack = new Stack<Integer>();
    /** Initialize your data structure here. */
    public MyQueue() 
    {

    }
    
    /** Push element x to the back of queue. */
    public void push(int x) 
    {
        pushStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() 
    {
        if (popStack.isEmpty())
        {
        	while(!pushStack.isEmpty())
        	{
        		popStack.push(pushStack.pop());
        	}
        }
        return popStack.pop();
    }
    
    /** Get the front element. */
    public int peek() 
    {
        if (popStack.isEmpty())
        {
        	while(!pushStack.isEmpty())
        	{
        		popStack.push(pushStack.pop());
        	}
        }
        return popStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() 
    {
        return pushStack.isEmpty() && popStack.isEmpty();
    }
}
