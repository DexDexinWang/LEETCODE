/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Aug 20, 2017 10:39:06 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

import java.util.HashSet;
import java.util.Set;
import generator.StringRandom;

public class Solution266 {

	public static void main(String[] args) 
	{
		String input = StringRandom.strGen(5);
		System.out.println(input);
		System.out.println(canPermutePalindrome(input));
		
	}
	
	
    public static boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<Character>();
        for(int i =0;i<s.length();i++)
        {
            if(!set.add(s.charAt(i)))
            {
                set.remove(s.charAt(i));
            }
        }
        return set.size()<=1;
     
    }

}
