/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Aug 18, 2017 11:56:36 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

public class Solution657 {

	public static void main(String[] args) 
	{
		String input = "UUDD";
		System.out.println(judgeCircle(input));
	}
	
    public static boolean judgeCircle(String moves) {
        int x=0, y=0;
        for(char ch: moves.toCharArray())
        {
        	switch(ch)
        	{
        	case 'U': x++;break;
        	case 'D': x--;break;
        	case 'L': y--;break;
        	case 'R': y++;break;
        	}
        }
        return x==0 && y==0;
    }

}
