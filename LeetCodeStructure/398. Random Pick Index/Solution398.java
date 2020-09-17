import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Solution398 {

	class Solution {
	    
	    Map<Integer, List<Integer>> map;
	    public Solution(int[] nums) {
	        map = new HashMap<>();
	        for(int i = 0; i < nums.length; i++) {
	            int key = nums[i];
	            map.putIfAbsent(key, new LinkedList<>());
	            map.get(key).add(i);
	        }
	    }
	    
	    public int pick(int target) {
	        if(map.containsKey(target)) {
	            Random random = new Random();
	            List<Integer> tempRes=  map.get(target);
	            return tempRes.get(random.nextInt(tempRes.size()));
	        }
	        return -1;
	    }
	}
	
	public class Solution1 {

	    int[] nums;
	    Random rnd;

	    public Solution1(int[] nums) {
	        this.nums = nums;
	        this.rnd = new Random();
	    }
	    
	    public int pick(int target) {
	        int result = -1;
	        int count = 0;
	        for (int i = 0; i < nums.length; i++) {
	            if (nums[i] != target)
	                continue;
	            if (rnd.nextInt(++count) == 0)
	                result = i;
	            /*
	            1 2 3 3 3 3 3 3   pick(3)
	                p p p p p p
	            
	            rnd.nextInt(1)  ---> choose value from 0 to 0  == 0 ;   1       100% to set value for result.
	            rnd.nextInd(2)  ---> choose value from 0 to 1  == 0 ;   1/2     50% to set value for result.
	            rnd.nextInd(3)  ---> choose value from 0 to 2  == 0 ;   1/3     33.33% to set value for result.
	                       3  3  3 
	                        
	            result = 2  first 3:  1           * (1-1/2)             * (1-1/3) =  1/3;
	                                  set 1st        not setup 2nd       not setup 3rd
	            result = 3  second 3: 
	             
	             
	            0-2
	            random pick 0-2 1/3
	            
	            
	            0   random 0       i = 0
	            0-1 random 0 1/2   i = 0 or 1
	            0-2 random 0 1/3   i = 0 , 1 ,2
	            
	             
	            */
	        }
	        
	        return result;
	    }
	}

}
