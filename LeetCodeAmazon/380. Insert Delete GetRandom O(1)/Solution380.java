import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Solution380 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class RandomizedSet {

	    Map<Integer,Integer> map;
	    List<Integer> list;
	    Random random;
	    /** Initialize your data structure here. */
	    public RandomizedSet() {
	        map = new HashMap<Integer,Integer>();
	        list = new ArrayList<>();
	        random = new Random();
	    }
	    
	    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	    public boolean insert(int val) {
	        if (map.containsKey(val)) return false;
	        list.add(val);
	        map.put(val, list.size() -1);
	        return true;
	    }
	    
	    /** Removes a value from the set. Returns true if the set contained the specified element. */
	    public boolean remove(int val) {
	        if(!map.containsKey(val)) return false;
	        int origIndex = map.get(val);
	        int lastElement = list.get(list.size() - 1);
	        map.put(lastElement, origIndex);
	        list.set(origIndex, lastElement);
	        map.remove(val);
	        list.remove(list.size() -1);
	        return true;
	    }
	    
	    /** Get a random element from the set. */
	    public int getRandom() {
	        return list.get(random.nextInt(list.size()));
	    }
	}

}
