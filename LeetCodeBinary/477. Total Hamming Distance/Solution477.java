/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on May 23, 2017 8:40:51 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

import java.util.Arrays;
import generator.IntegerRandom;

public class Solution477 {

	public static void main(String[] args) 
	{
		int[] input = new int[5];
		for(int i=0; i < input.length; i++)
		{
			input[i]=IntegerRandom.range(0, 10);
		}
		
		System.out.println(Arrays.toString(input));
		System.out.println(totalHammingDistance(input));
	}
	public static int totalHammingDistance(int[] nums) 
    {
        int result = 0 ; 
        int length = nums.length;
        for(int i =0; i<32 ; i++)
        {
            int bitCount = 0;
            for(int j=0; j<length;j++)
            {
                bitCount += (nums[j]>>i) & 1;
            }
            result += bitCount*(length-bitCount);
        }
        return result;
    }

}
