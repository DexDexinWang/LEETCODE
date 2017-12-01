import java.util.Arrays;

/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on May 28, 2017 9:07:10 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.

Example 1:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".
Example 2:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
 */

import java.util.HashMap;
import java.util.LinkedList;

public class Solution599 {
	public static void main(String[] args) 
	{
		String[] input1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
		String[] input2 = {"KFC", "Shogun", "Burger King"};
		System.out.println(Arrays.toString(findRestaurant(input1,input2)));
	}
	
    public static String[] findRestaurant(String[] list1, String[] list2) 
    {
    	HashMap<String,Integer> map = new HashMap<String,Integer>();
    	for(int i =0; i<list1.length; i++) map.put(list1[i], i);
    	
    	int minSum=Integer.MAX_VALUE;
    	LinkedList<String> result = new LinkedList<String>();
    	for(int i =0; i < list2.length; i++)
    	{
    		Integer j = map.get(list2[i]);
    		if(j!=null && i+j<minSum)
    		{
    			if(i+j<minSum)
    			{
    				result=new LinkedList<String>();
    				minSum = i +j;
    			}
    			result.add(list2[i]);
    		}
    	}
    	return result.toArray(new String[result.size()]);
    }
}
