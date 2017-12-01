/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 10, 2017 8:25:15 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital if it has more than one letter, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
*/

import generator.StringRandom;

public class Solution520 {
	public static void main(String[] args) 
	{
		String input = StringRandom.strAlphabetGen(5);
		System.out.println("Leetcode");
		System.out.println(detectCapitalUse(input));
	}
	
    public static boolean detectCapitalUse(String word) 
    {
    	int counter =0;
    	for (int i=0; i<word.length(); i++)
    	{
    		if (Character.isUpperCase(word.charAt(i)))
    		{
    			counter ++;
    		}
    	}
    	if (counter == 1 )
    	{
    		return Character.isUpperCase(word.charAt(0));
    	}
    	return counter==0 || counter==word.length();
    }
}
