import java.util.Deque;
import java.util.LinkedList;

public class PerformStringShifts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    //Solve the problem with Deque
    public String stringShift(String s, int[][] shift) {
        //Corner Case
        if (s == null || s.length() == 0 ) {
            return s;
        }
        Deque<Character> input = new LinkedList<>();
        for(Character c : s.toCharArray()) {
            input.offerLast(c);
        }
        for(int[] action: shift) {
            for(int i = 0; i < action[1]; i++) {
                if (action[0] == 0) {
                	input.offerLast(input.pollFirst()); 
                } else {
                	input.offerFirst(input.pollLast());
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!input.isEmpty()) {
            sb.append(input.pollFirst());
        }
        return sb.toString();
    }
    
    public String stringShift1(String s, int[][] shift) {
        //Corner Case
        if (s == null || s.length() == 0 ) {
            return s;
        }
        int current = 0;
        for(int[] action: shift) {
            if (action[0] == 0) {
            	current += action[1]; 
            } else {
            	current -= action[1];
            }
            current = current % s.length();
            if(current < 0) {
                current = s.length() + current;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        char[] array = s.toCharArray(); 
        for(int i = 0; i < array.length; i++) {
        	sb.append(array[(current + i) % array.length]); 
        }
        return sb.toString();
    }
	
    
}
