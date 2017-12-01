/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on May 28, 2017 9:42:56 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

import java.util.Arrays;
import generator.ArrayRandom; 
import java.util.HashMap;


public class Solution594 {
	public static void main(String[] args) 
	{
		int[] input = ArrayRandom.arrayGen(10, 0, 10);
		System.out.println(Arrays.toString(input));
		System.out.println(findLHS(input));
	}
	
    public static int findLHS(int[] nums) 
    {
    	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    	for(int s:nums)
    	{
    		map.put(s,map.getOrDefault(s,0)+1);
    	}
    	
    	int result= 0 ;
    	for(int key:map.keySet())
    	{
    		if(map.containsKey(key+1))
    		{
    			result=Math.max(result, map.get(key+1)+map.get(key));
    		}
    	}
    	return result;
    }

}
