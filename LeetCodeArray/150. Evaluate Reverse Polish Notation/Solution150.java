import java.util.Deque;
import java.util.LinkedList;

public class Solution150 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Solution150 s = new Solution150();
			int res = s.evalRPN(new String[] {"4","13","5","/","+"});
			System.out.print(res);
	}

	
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for(String str : tokens) {
            if(str.equals("+")) {
                stack.addLast(stack.removeLast() + stack.removeLast());
            } else if(str.equals("-")) {
                stack.addLast(-(stack.removeLast() - stack.removeLast()));
            } else if (str.equals("*")) {
                stack.addLast(stack.removeLast() * stack.removeLast());
            } else if (str.equals("/")) {
                int a = stack.removeLast();
                int b = stack.removeLast();
                if(a == 0) {
                    stack.addLast(0);
                } else {
                    stack.addLast(b / a);
                }
            } else {
                stack.add(Integer.valueOf(str));
            }
        }
        return stack.removeLast();
    }
}
