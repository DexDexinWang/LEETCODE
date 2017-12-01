/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Aug 20, 2017 1:16:00 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

import java.util.Arrays;
public class Solution252 {
	public static void main(String[] args) 
	{
		
	}

    public static boolean canAttendMeetings(Interval[] intervals) {
        int  len = intervals.length;
        if(len==0) return true;
        int[] start = new int[len];
        int[] stop = new int[len];
        for(int i =0; i<len;i++)
        {
            start[i]=intervals[i].start;
            stop[i]=intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(stop);
        
        for(int i =1;i<len;i++)
        {
            if(start[i]<stop[i-1])
            {
                return false;
            }
        }
        return true;
    }
}


class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) 
    { 
    	start = s; end = e; 
    }
}
