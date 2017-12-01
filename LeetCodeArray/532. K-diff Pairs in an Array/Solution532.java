

/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on May 29, 2017 12:23:45 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */
import java.util.Arrays;
import generator.ArrayRandom;
import java.util.HashMap;

public class Solution532 {
	public static void main(String[] args) 
	{
		int[] input = ArrayRandom.arrayGen(10, 0, 10);
		System.out.println(Arrays.toString(input));
		System.out.println(findPairs(input,5));
	}
	
    public static int findPairs(int[] nums, int k) {
        if(k < 0) return 0;
        HashMap<Integer,Boolean> map = new HashMap<Integer,Boolean>();
        int result=0;
        for(int i: nums)
        {
        	if(map.containsKey(i-k) && !map.get(i-k) ) 
        	{
        		result++;
        		map.put(i-k, true);
        	}
        	if(map.containsKey(i+k))
        	{
        		if(!map.containsKey(i) || !map.get(i))
        		{
        			map.put(i,true);
        			result++;
        		}
        	}
            if(!map.containsKey(i))
            {
                map.put(i, false);
            }
        }
        return result;
        
    }

}
