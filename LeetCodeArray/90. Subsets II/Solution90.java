/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on May 29, 2017 6:35:50 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

import java.util.Arrays;
import generator.ArrayRandom;
import java.util.List;

public class Solution90 {
	public static void main(String[] args) 
	{
		int[] input = ArrayRandom.arrayGen(10, 0, 10);
		System.out.println(Arrays.toString(input));
		System.out.println(Arrays.deepToString(subsetsWithDup(input)));
	}

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        
    }
}
