/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on May 23, 2017 4:47:01 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

public class Solution393 {
	public static void main(String[] args) 
	{
		int[] input ={1,2,3,4,5,6};
		System.out.println(validUtf8(input));
	}
	
    public static boolean validUtf8(int[] data) 
    {
    	if(data==null || data.length==0) return false;
    	int count =0;
    	for(int a:data)
    	{
    		if(count==0)
    		{
    			if((a>>5)==0b110) count =1;
    			else if((a>>4)==0b1110) count =2;
    			else if((a>>3)==0b11110) count = 3;
    			else if ((a>>7)==1) return false;
    		}
    		else 
    		{
    			if((a>>6)!=0b10) return false;
    			else count--;
    		}
    	}
    	return count==0;
    }
}
