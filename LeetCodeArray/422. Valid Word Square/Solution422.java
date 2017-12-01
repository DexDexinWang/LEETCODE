/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Aug 23, 2017 1:34:35 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a sequence of words, check whether it forms a valid word square.

A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ¡Ü k < max(numRows, numColumns).

Note:
The number of words given is at least 1 and does not exceed 500.
Word length will be at least 1 and does not exceed 500.
Each word contains only lowercase English alphabet a-z.
Example 1:

Input:
[
  "abcd",
  "bnrt",
  "crmy",
  "dtye"
]

Output:
true

Explanation:
The first row and first column both read "abcd".
The second row and second column both read "bnrt".
The third row and third column both read "crmy".
The fourth row and fourth column both read "dtye".

Therefore, it is a valid word square.
Example 2:

Input:
[
  "abcd",
  "bnrt",
  "crm",
  "dt"
]

Output:
true

Explanation:
The first row and first column both read "abcd".
The second row and second column both read "bnrt".
The third row and third column both read "crm".
The fourth row and fourth column both read "dt".

Therefore, it is a valid word square.
Example 3:

Input:
[
  "ball",
  "area",
  "read",
  "lady"
]

Output:
false

Explanation:
The third row reads "read" while the third column reads "lead".

Therefore, it is NOT a valid word square.
 
*/

import java.util.List;
import java.util.LinkedList;

public class Solution422 {
	public static void main(String[] args) 
	{
		List<String> input= new LinkedList<String>();
		input.add("abcd");
		input.add("bnrt");
		input.add("crmy");
		input.add("dtye");
		
		System.out.println(validWordSquare(input));
	}
	
	 public static boolean validWordSquare(List<String> words) 
	 {  
		 if(words.size() == 0) return true;
     
	     for(int i=0; i<words.size(); i++){
	         String s = words.get(i);
	         if(!s.equals(getVerticalString(i, words))){
	             return false;
	         }
	     }
	     
	     return true;
	 }
 
	 private static String getVerticalString(int col, List<String> words){
	     StringBuilder sb = new StringBuilder();
	     
	     for(int i=0; i<words.size(); i++){
	         String word = words.get(i);
	         if(col < word.length()){
	             sb.append(word.charAt(col));
	         }
	         
	     }
	     return sb.toString();
	 }
}
