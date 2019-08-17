package integer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import integer.RandomInteger;
import keywords.keys;

public class RandomIntegerArray {

	/**
	 * To generate a random array with given length
	 */
	public static int[] arrayGen(int len)
	{
		return arrayGen(len, keys.MIN, keys.MAX);
	}
	/**
	 * To generate a random array with given length, min, and max
	 */
	public static int[] arrayGen(int len,int min, int max)
	{
		int[] array = new int[len];
		for(int i=0; i<len; i++)
		{
			array[i]=RandomInteger.range(min,max);
		}
		return array;
	}
	
	/**
	 * To generate a random array with given length
	 */
	public static int[] arrayGenNoDuplication(int len)
	{
		return arrayGenNoDuplication(len, keys.MIN, keys.MAX);
	}
	
	/**
	 * To generate a random array with given length, min, max
	 */
	public static int[] arrayGenNoDuplication(int len, int min, int max)
	{
		Set<Integer> uniqueNumbers = new HashSet<>();
		while (uniqueNumbers.size()<len)
		{
			uniqueNumbers.add(RandomInteger.range(min,max));
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
	
	public static int[] sortedArrayGen(int len, int min, int max) {
		int[] res = arrayGen(len,min,max);
		Arrays.sort(res);
		return res;
	}
	
	public static int[] sortedArrayGen(int len) {
		return sortedArrayGen(len,keys.MIN,keys.MAX);
	}
	
	public static int[] sortedNoDuplicatedArrayGen(int len, int min, int max) {
		int[] res = arrayGenNoDuplication(len,min,max);
		Arrays.sort(res);
		return res;
	}
	
	public static int[] sortedNoDuplicatedArrayGen(int len) {
		return sortedNoDuplicatedArrayGen(len, keys.MIN, keys.MAX);
	}
	
	public static int[][] twoDNoDuplicatedArrayGen(int len, int min, int max) {
		if (len >= 1) {
			int root = (int) Math.sqrt(len);
			if (root * root == len) {
				int[][] res = new int[root][root];
				int[] oneDArray = sortedNoDuplicatedArrayGen(len, min, max);
				for (int i = 0; i < root; i++) {
					int[] temp = res[i];
					for(int j = 0; j < root; j++) {
						temp[j] = oneDArray[i*root + j];
					}
				}
				return res;
			}
		}
		return null;
	}
	
}
