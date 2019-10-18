import java.util.Deque;
import java.util.LinkedList;

public class Solution5222 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int balancedStringSplit(String s) {
        Deque<Character> stack  = new LinkedList<Character>();
        char record = 0;
        int counter = 0;
        for(char c: s.toCharArray()) {
            if (stack.size() == 0) {
            	counter++;
            	record = c;
            	stack.offerFirst(c);
            } else {
            	if(record == c) {
            		stack.offerFirst(c);
            	} else {
            		stack.pollFirst();
            	}
            }
        }
        return counter;
    }

}
