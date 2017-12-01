/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 1, 2017 11:58:07 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */
package generator;



import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
import java.util.ArrayList;

public class ArrayRandom 
{
	private static final int MIN=0;
	private static final int MAX=100000;
	
	/**
	 * To return a random integer with minimum value and maximum value
	 */
	public static int range(int min,int max)
	{
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}
	
	/**
	 * To return a random integer with final minimum value and final maximum value
	 */
	public static int range()
	{
		return ThreadLocalRandom.current().nextInt(MIN, MAX);
	}
	
	
	/**
	 * To generate a random array with given length
	 */
	public static int[] arrayGen(int len)
	{
		int[] array = new int[len];
		for(int i=0; i<len; i++)
		{
			array[i]=range(MIN,MAX);
		}
		return array;
	}
	/**
	 * To generate a random array with given length, min, and max
	 */
	public static int[] arrayGen(int len,int min, int max)
	{
		int[] array = new int[len];
		for(int i=0; i<len; i++)
		{
			array[i]=range(min,max);
		}
		return array;
	}
	
	/**
	 * To generate a random array with given length
	 */
	public static int[] arrayGenNoDuplication(int len)
	{
		Set<Integer> uniqueNumbers = new HashSet<>();
		while (uniqueNumbers.size()<len)
		{
			uniqueNumbers.add(range(MIN,MAX));
		}
		int[] array = new int[len];
		int c = 0;
		for(int x : uniqueNumbers) 
		{
			array[c++] = x;
		}
		return array;
	}
	
	/**
	 * To generate a random array with given length, min, max
	 */
	public static int[] arrayGenNoDuplication(int len, int min, int max)
	{
		Set<Integer> uniqueNumbers = new HashSet<>();
		while (uniqueNumbers.size()<len)
		{
			uniqueNumbers.add(range(min,max));
		}
		int[] array = new int[len];
		int c = 0;
		for(int x : uniqueNumbers) 
		{
			array[c++] = x;
		}
		return array;
	}
	
	/**
	 * To generate a random sub-array according to an array
	 */
	public static int[] subarrayGen(int[] array)
	{
		ArrayList<Integer> output = new ArrayList<Integer>();
		Random rm = new Random();
		for(int i=0; i<array.length; i++)
		{
			if(rm.nextBoolean())
			{
				output.add(array[i]);
			}
		}
		return output.stream().mapToInt(i -> i).toArray();
	}
	
}
