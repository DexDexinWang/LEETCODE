/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on May 29, 2017 6:23:59 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

import java.util.Arrays;
import generator.ArrayRandom;

public class Solution414 {
	public static void main(String[] args)
	{
		int[] input = ArrayRandom.arrayGen(10, 0, 10);
		System.out.println(Arrays.toString(input));
		System.out.println(thirdMax(input));
	}
	
    public static int thirdMax(int[] nums) 
    {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        
        for(Integer i: nums)
        {
        	if(i.equals(max1) || i.equals(max2) || i.equals(max3)) continue;
        	if(max1==null || i>max1)
        	{
        		max3=max2;
        		max2=max1;
        		max1=i;
        	}
        	else if(max2==null || i>max2)
        	{
        		max3=max2;
        		max2=i;
        	}
        	else if(max3==null || i>max3)
        	{
        		max3=i;
        	}
        }
        return max3==null? max1:max3;
    }
}
