/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on May 30, 2017 11:45:21 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

import java.util.Stack;

public class MinStack {
	  /** initialize your data structure here. */
	int min = Integer.MAX_VALUE;
	Stack<Integer> stack = new Stack<Integer>();
    
	public MinStack() {
        
    }
    
    public void push(int x) {
        if(x<=min)
        {
        	stack.push(min);
        	min=x;
        }
        stack.push(x);
    }
    
    public void pop() {
        if(stack.pop()==min) min=stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}
