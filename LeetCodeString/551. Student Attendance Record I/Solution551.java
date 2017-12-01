/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Apr 20, 2017 5:57:57 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
You are given a string representing an attendance record for a student. The record only contains the following three characters:

'A' : Absent.
'L' : Late.
'P' : Present.
A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

You need to return whether the student could be rewarded according to his attendance record.
 */

public class Solution551 {
	public static void main(String[] args) {
		String input = "PPALLL";
		System.out.println(checkRecord(input));
	}
	
    public static boolean checkRecord(String s) 
    {
    	int countA=0;
    	int countL=0;
    	for(int i=0; i<s.length(); i++)
    	{
    		if(s.charAt(i) == 'A'){
                if(countA == 1){
                    return false;
                } else{
                    countA = countA + 1;
                }
                countL = 0;
            } else if(s.charAt(i) == 'L'){
                if(countL == 2){
                    return false;
                } else{
                    countL = countL + 1;
                }
            } else{
                countL = 0;
            }
    	}
    	return true;

    	// slow return !s.matches(".*LLL.*|.*A.*A.*");
    }

}
