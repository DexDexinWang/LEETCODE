/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 7, 2017 6:54:32 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
import generator.StringRandom;
import java.util.HashMap;

public class Solution3 {
	public static void main(String[] args) 
	{
		String input =StringRandom.strGen(10);
		System.out.println(input);
		System.out.println(lengthOfLongestSubstring(input));
	}
	
    public static int lengthOfLongestSubstring(String s) 
    {
    	// O(n)
    	HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
    	int result=0;
    	for(int i=0,j=0; j<s.length();j++)
    	{
    		if(hm.containsKey(s.charAt(j)))
    		{
    			i=Math.max(hm.get(s.charAt(j)), i);
    		}
    		result = Math.max(result, j-i+1);
    		hm.put( s.charAt(j), j+1);
    	}
    	return result;
    	
    	/* O(2N) 
        HashSet<Character> set = new HashSet<Character>();
        int result=0, i=0, j=0, n=s.length();
        while(i<n && j<n)
        {
        	if(!set.contains(s.charAt(j)))
        	{
        		set.add(s.charAt(j++));
        		result = Math.max(result, set.size());
        	}
        	else
        	{
        		set.remove(s.charAt(i++));
        	}
        }
        return result;
        */
    }

}
