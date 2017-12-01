import java.util.Arrays;

/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Jun 11, 2017 11:22:42 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.

Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.

So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.

Note:
Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
As long as a house is in the heaters' warm radius range, it can be warmed.
All the heaters follow your radius standard and the warm radius will the same.
Example 1:
Input: [1,2,3],[2]
Output: 1
Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
Example 2:
Input: [1,2,3,4],[1,4]
Output: 1
Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.
 */

public class Solution475 
{
	public static void main(String[] args) 
	{
		int[] input1 = {1,2,3,4};
		int[] input2 = {1,4};
		System.out.println(findRadius(input1,input2));
	}

    public static int findRadius(int[] houses, int[] heaters) 
    {
        Arrays.sort(heaters);
        Arrays.sort(houses);

        int i=0, j = 0 , result=0;
        
        while(i<houses.length)
        {
        	while(j<heaters.length-1 && 
        			Math.abs(heaters[j+1]-houses[i])<Math.abs(heaters[j]-houses[i]))
        	{
        		j++;
        	}
        	result = Math.max(result,Math.abs(heaters[j]-houses[i]));
        	i++;
        }
        return result;
    }
}
