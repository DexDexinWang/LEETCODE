/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Aug 20, 2017 12:56:00 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

import java.util.List;
import java.util.ArrayList;

public class Solution293 {
	public static void main(String[] args) {
		System.out.println(generatePossibleNextMoves("++++"));
	}

	
    public static List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<String>();
        for(int i =-1; (i=s.indexOf("++",i+1))>=0;)
        {
            result.add(s.substring(0,i)+"--"+s.substring(i+2));
        }
        return result;
    }
}
