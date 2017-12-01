/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 7, 2017 10:51:10 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */
package generator;

import generator.StringRandom;
import java.util.Random;

public class StringArrayRandom {
	
	/**
	 * To generate a random string Array with given size and length for each string array 
	 */
	public static String[] strArrayGen(int size, int len)
	{
		String[] result = new String[size];
		for(int i=0; i< size; i++)
		{
			result[i]=StringRandom.strAlphabetGen(len);
		}
		return result;
	}
	
	/**
	 * To generate a random string Array with given length for each string array 
	 */
	public static String[] strArrayGen(int len)
	{
		Random rd = new Random();
		int size = rd.nextInt(50);
		String[] result = new String[size];
		for(int i=0; i< size; i++)
		{
			result[i]=StringRandom.strAlphabetGen(len);
		}
		return result;
	}

}
