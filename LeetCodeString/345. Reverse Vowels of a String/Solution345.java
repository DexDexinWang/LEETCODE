/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 23, 2017 8:27:09 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".
 */

import generator.StringRandom;
import java.util.Set;
import java.util.HashSet;

public class Solution345 {
	public static void main(String[] args) {
		String input = StringRandom.strAlphabetSmaGen(10);
		System.out.println(input+"\t"+ reverseVowels(input));
	}
	
    public static String reverseVowels(String s) 
    {
    	Set<Character> set = new HashSet<Character>();
    	set.add('a');
    	set.add('e');
    	set.add('i');
    	set.add('o');
    	set.add('u');
    	set.add('A');
    	set.add('E');
    	set.add('I');
    	set.add('O');
    	set.add('U');
    	
    	char[] list = s.toCharArray();
    	
    	int i =0, j = list.length-1;
    	while(i<j)
    	{
    		if(!set.contains(list[i]))
    		{
    			i++;
    			continue;
    		}
    		
    		if(!set.contains(list[j]))
    		{
    			j--;
    			continue;
    		}
    		char temp = list[i];
    		list[i] = list[j];
    		list[j] = temp;
    		i++;
    		j--;
    		
    	}
    	return new String(list);
    }

}
