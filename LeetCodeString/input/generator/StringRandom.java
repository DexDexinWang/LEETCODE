/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 1, 2017 4:47:27 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */
package generator;

import java.security.SecureRandom;

public class StringRandom 
{
	private static final String A = "abcdefghijklmnopqrstuvwxyz";
	private static final String B = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String C = "0123456789";
	private static final String D = " ";
	private static SecureRandom rnd = new SecureRandom();

	/**
	 * To generate a random string with given length
	 */
	public static String strGen(int len)
	{
		StringBuilder sb = new StringBuilder(len);
		for(int i = 0; i < len; i++)
		{
			sb.append((A+B+C).charAt(rnd.nextInt((A+B+C).length())));	
		}
		return sb.toString();
	}
	
	/**
	 * To generate a random string with given length
	 */
	public static String strAlphabetGen(int len)
	{
		StringBuilder sb = new StringBuilder(len);
		for(int i = 0; i < len; i++)
		{
			sb.append((A+B).charAt(rnd.nextInt((A+B).length())));	
		}
		return sb.toString();
	}
	
	/**
	 * To generate a random string and blank space with given length and space 
	 */
	public static String strAlphabetSpceGen(int len)
	{
		StringBuilder sb = new StringBuilder(len);
		for(int i = 0; i < len; i++)
		{
			sb.append((A+B+D).charAt(rnd.nextInt((A+B+D).length())));	
		}
		return sb.toString();
	}
	/**
	 * To generate a random Capital string with given length and space 
	 */
	public static String strAlphabetCapGen(int len)
	{
		StringBuilder sb = new StringBuilder(len);
		for(int i = 0; i < len; i++)
		{
			sb.append((B).charAt(rnd.nextInt((B).length())));	
		}
		return sb.toString();
	}
	
	/**
	 * To generate a small random string with given length and space 
	 */
	public static String strAlphabetSmaGen(int len)
	{
		StringBuilder sb = new StringBuilder(len);
		for(int i = 0; i < len; i++)
		{
			sb.append((A).charAt(rnd.nextInt((A).length())));	
		}
		return sb.toString();
	}
	
	/**
	 * To generate a small random string with given length and space 
	 */
	public static String strNumGen(int len)
	{
		StringBuilder sb = new StringBuilder(len);
		for(int i = 0; i < len; i++)
		{
			sb.append((C).charAt(rnd.nextInt((C).length())));	
		}
		return sb.toString();
	}
	
	/**
	 * To generate a random palindromic string with given length
	 */
	public static String strGenPD(int len)
	{
		boolean isEven= (len & 1)==0 ? true : false;
		int mid = (len+1)/2;
		StringBuilder sb = new StringBuilder(mid);
		for(int i = 0; i < mid; i++)
		{
			sb.append((A+B).charAt(rnd.nextInt((A+B).length())));	
		}
		String temp=sb.toString();
		sb.reverse().append(temp);
		if(!isEven)
		{
			sb.deleteCharAt(mid);
		}
		return sb.toString();
	}
	
}
