/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 7, 2017 10:58:13 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/**
 * Given a List of words, return the words that can be typed 
 * using letters of alphabet on only one row's of American keyboard like the image below.
 */

import generator.StringArrayRandom;
import java.util.ArrayList;


public class Solution500 {
	
	private static String[] lines = new String[]{"qwertyuiop","asdfghjkl","zxcvbnm"};
	
	public static void main(String[] args) {
		String[] input=StringArrayRandom.strArrayGen(10, 3);
		for(int i=0; i<input.length; i++)
		{
			System.out.println(input[i]);
		}
		System.out.println("----------split line-----------");
		String[] output=findWords(input);
		for(int i=0; i<output.length; i++)
		{
			System.out.println(output[i]);
		}
	}
	
    public static String[] findWords(String[] words) 
    {
    	//String[]::new is a syntax sugar for the lambda expression size -> new String[size].
    	//Even this one line is enough, it will cost more time.
    	//return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
    	
    	ArrayList<String> result=new ArrayList<String>();
    	int currentLine = 0; 
    	for (String s: words)
    	{
    		String temp = s.toLowerCase();
    		currentLine = getCurrentLine(temp.charAt(0));
        	boolean found =true;
        	
        	for (char c: temp.toCharArray())
        	{
        		if(lines[currentLine].indexOf(c)==-1)
        		{
        			found = false;
        			break;
        		}
        	}
        	
        	if (found)
        	{
        		result.add(s);
        	}
    	}
    	return result.toArray(new String[result.size()]);
    }
    
    private static int getCurrentLine(char c)
    {
    	for(int i=0; i<3; i++)
    	{
    		if (lines[i].indexOf(c)!=-1)
    		{
    			return i;
    		}
    	}
    	return -1;
    }

}
