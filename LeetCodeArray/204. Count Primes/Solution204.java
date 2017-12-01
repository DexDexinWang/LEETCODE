/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 24, 2017 9:21:26 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Description:

Count the number of prime numbers less than a non-negative number, n.
 */

import generator.ArrayRandom;

public class Solution204 {
	public static void main(String[] args) {
		int input = ArrayRandom.range();
		System.out.println(input+"\t"+countPrimes(input));
	}

	public static int countPrimes(int n) 
	{
		boolean[] notPrime = new boolean[n];
		int count= 0;
		for(int i =2; i <n; i++)
		{
			if(notPrime[i]==false)
			{
				count++;
				for(int j=2; j*i < n ; j++)
				{
					notPrime[i*j]=true;
				}
			}
		}
		return count++;
	}	
}
