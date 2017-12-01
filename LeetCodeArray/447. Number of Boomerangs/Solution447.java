import java.util.HashMap;

/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 14, 2017 3:18:05 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) 
such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are 
all in the range [-10000, 10000] (inclusive).
 */

public class Solution447 {
	public static void main(String[] args) 
	{
		int[][] input = {{0,0},{1,0},{2,0}};
		System.out.println(numberOfBoomerangs(input));
	}
	
    public static int numberOfBoomerangs(int[][] points) 
    {
    	int result=0;
    	HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
    	for(int i=0; i < points.length; i++)
    	{
    		for(int j=0; j< points.length; j++)
    		{
    			if (i == j)
    			{
    				continue;
    			}
    			int d=distance(points[i],points[j]);
    			hm.put(d, hm.getOrDefault(d, 0) + 1);
    		}	
    		for(int value: hm.values())
    		{
    			result+=value*(value-1);
    		}
    		hm.clear();
    	}
    	

    	
		return result;
    	
    }
    
    private static int distance(int[] a, int[] b)
    {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];
        
        return dx*dx + dy*dy;
    }

}
