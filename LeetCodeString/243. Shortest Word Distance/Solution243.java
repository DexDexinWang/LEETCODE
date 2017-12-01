/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Aug 20, 2017 10:56:57 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

//Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
//
//For example,
//Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
//
//Given word1 = ¡°coding¡±, word2 = ¡°practice¡±, return 3.
//Given word1 = "makes", word2 = "coding", return 1.
//
//Note:
//You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

import java.util.Arrays;

public class Solution243 {

	public static void main(String[] args) {
		String[] input = {"practice", "makes", "perfect", "coding", "makes"};
		System.out.println(Arrays.toString(input));
		System.out.println(shortestDistance(input,"perfect","coding"));
	}
	
    public static int shortestDistance(String[] words, String word1, String word2) {
        int result = Integer.MAX_VALUE, index1=-1,index2=-1;
        for(int i =0; i<words.length; i++)
        {
            if(words[i].equals(word1))
            {
                index1=i;
                if(index2>=0) result= Math.min(result,i-index2);
            }
            else if(words[i].equals(word2))
            {
                index2=i;
                if(index1>=0) result= Math.min(result,i-index1);
            }
        }
        return result;
    }
}
