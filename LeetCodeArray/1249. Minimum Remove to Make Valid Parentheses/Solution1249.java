import java.util.Deque;
import java.util.LinkedList;

public class Solution1249 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution1249().minRemoveToMakeValid("())()((("));
	}
	class Pair{
		char c;
		int index;
		public Pair(char c, int index) {
			this.c = c;
			this.index = index;
		}
	}
    public String minRemoveToMakeValid(String s) {
        int size = s.length();
        Deque<Pair> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int deletedNum = 0;
        for(int i = 0; i < size; i++) {
            char c = s.charAt(i);
            if(c != ')') {
                if(c == '('){
                    stack.offerLast(new Pair(c,i - deletedNum));
                }
                sb.append(c);
            } else {
                if (!stack.isEmpty() && stack.peekLast().c == '(') {
                    stack.pollLast();
                    sb.append(c);
                } else  {
                	deletedNum+=1;
                }
            }
        }
        while(!stack.isEmpty()) {
        	sb.deleteCharAt(stack.pollLast().index);
        }
        return sb.toString();
    }
}
