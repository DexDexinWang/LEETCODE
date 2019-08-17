/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 7, 2017 8:14:09 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */
package generator;

import java.util.concurrent.ThreadLocalRandom;

public class IntegerRandom 
{
	private static final int MIN=0;
	private static final int MAX=100000;
	
	/**
	 * To return a random integer with final minimum value and final maximum value
	 */
	public static int range()
	{
		return range(MIN, MAX);
	}
	
	/**
	 * To return a random integer with minimum value and maximum value
	 */
	public static int range(int min,int max)
	{
		return ThreadLocalRandom.current().nextInt(min, max);
	}
	
	
}
