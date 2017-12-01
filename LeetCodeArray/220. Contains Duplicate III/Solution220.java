/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on May 29, 2017 11:15:54 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

import java.util.Arrays;
import generator.ArrayRandom; 
import java.util.HashMap;

public class Solution220 {

	public static void main(String[] args) {
		int[] input = ArrayRandom.arrayGen(10, 0, 10);
		System.out.println(Arrays.toString(input));
		System.out.println(containsNearbyAlmostDuplicate(input,5,10));
	}

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(t<0 || k<0) return false;
        HashMap<Long,Long> map = new HashMap<Long,Long>();
        long w = (long) t+1;
        for(int i = 0 ; i < nums.length; i++)
        {
        	long m = getID(nums[i],w);
        	if(map.containsKey(m)) return true;
        	if(map.containsKey(m-1) && Math.abs(nums[i]-map.get(m-1))<w) return true;
        	if(map.containsKey(m+1) && Math.abs(nums[i]-map.get(m+1))<w) return true;
        	map.put(m, (long)nums[i]);
        	if(i>k) map.remove(getID(nums[i-k],w));
        }
        return false;
    }
    
    private static long getID(long i, long w)
    {
    	return i<0? (i+1)/w-1 : i/w;
    }
}
