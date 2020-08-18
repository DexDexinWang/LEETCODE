import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution1429 {

	public static void main(String[] args) {

	}
	
	class FirstUnique {
	    Map<Integer,Boolean> isUnitMap;
	    Deque<Integer> que;
	    public FirstUnique(int[] nums) {
	        isUnitMap = new HashMap<>();
	        que = new LinkedList<>();
	        for(int num: nums) {
	            add(num);
	        }
	    }
	    
	    public int showFirstUnique() {
	        while(!que.isEmpty()) {
	            if(isUnitMap.get(que.peekFirst())) {
	                return que.peekFirst();
	            }
	            que.pollFirst();
	        }
	        return -1;
	    }
	    
	    public void add(int value) {
	        que.offerLast(value);
	        if(isUnitMap.containsKey(value)){
	            isUnitMap.put(value, false);
	        } else {
	            isUnitMap.put(value, true);
	        }
	    }
	}

    
}
