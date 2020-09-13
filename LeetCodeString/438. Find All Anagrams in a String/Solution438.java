/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Jun 11, 2017 10:03:59 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Solution438 {
	public static void main(String[] args) 
	{
		String input1 ="abab";
		String input2 = "ab";
		for(int i: findAnagrams(input1,input2))
		{
			System.out.println(i);
		}
	}
	
	public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        int[] count = new int[26];
        for(char c: p.toCharArray()) {
            count[c-'a']++;
        }
        int total = 0;
        for(int i = 0; i < 26; i++) {
            if(count[i]!= 0) total++;
        }
        int swLen = p.length();
        int left = 0;
        int right = 0;
        while(right < s.length()) {
            char rightChar = s.charAt(right);
            count[rightChar-'a']--;
            if(count[rightChar - 'a'] == 0) {
                total--;
            }
            
            if(right - left + 1 == swLen) {
                if (total == 0) {
                    res.add(left);
                }
                char leftChar = s.charAt(left);
                count[leftChar - 'a']++;
                if(count[leftChar - 'a']==1) {
                    total++;
                }
                left++;
            }
            right ++;
        }
        return res;
    }
	
    public static List<Integer> findAnagrams1(String s, String p) 
    {
    	List<Integer> list = new ArrayList<Integer>();
    	if(s==null || s.length()==0 || p==null || p.length()==0) return list;
    	int[] hash = new int[256];
    	for(char c: p.toCharArray())
    	{
    		hash[c]++;
    	}
    	int left=0, right=0, count= p.length();
    	while(right<s.length())
    	{
    		if(hash[s.charAt(right++)]-- >= 1) count--;
    		if(count==0) list.add(left);
    		if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
    	}
    	return list;
    }
}
