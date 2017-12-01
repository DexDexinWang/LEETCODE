import java.util.Stack;

/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 24, 2017 8:44:54 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */

public class Solution20 {
	public static void main(String[] args) 
	{
		String input="(";
		System.out.println(isValid(input));
	}
	
    public static boolean isValid(String s) 
    {
        Stack<Character> set = new Stack<Character>();
        for(char c: s.toCharArray())
        {
            switch(c)
            {
                case '(': 
                    set.push(')');
                    break;
                case '{': 
                    set.push('}');
                    break;
                case '[':
                    set.push(']');
                    break;
                default:
                    if(set.isEmpty() || set.pop()!=c)
                    {
                        return false;
                    }
            }
        }
        return set.isEmpty();
    }

}
