import java.util.Deque;
import java.util.LinkedList;

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