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

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

class MinStack {
    public Deque<Integer> stack;
    public Deque<Integer> min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        min = new LinkedList<>();
    }
    
    public void push(int x) {
        stack.offerLast(x);
        Integer minCompare = min.peekLast();
        min.offerLast((minCompare == null || x < minCompare) ? x : minCompare);
    }
    
    public void pop() {
        stack.pollLast();
        min.pollLast();
    }
    
    public int top() {
        return stack.peekLast();
    }
    
    public int getMin() {
        return min.peekLast();
    }
}
