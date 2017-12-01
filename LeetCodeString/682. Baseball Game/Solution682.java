/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Oct 25, 2017 12:03:17 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

import java.util.LinkedList;
public class Solution682 {
	public static void main(String[] args) 
	{
		String[] input = {"5","2","C","D","+"};
		System.out.println(calPoints(input));
	}
	
	public static int calPoints(String[] ops) 
	{
		if(ops==null || ops.length==0) return 0;
		int sum = 0;
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(String op: ops)
		{
			switch(op)
			{
			case "C":
				sum-=list.removeLast();
				break;
			case "D":
				list.add(list.peekLast()*2);
				sum+=list.peekLast();
				break;
			case "+":
				list.add(list.peekLast() + list.get(list.size()-2));
				sum+=list.peekLast();
				break;
			default:
				list.add(Integer.parseInt(op));
				sum+=list.peekLast();
			}
		}
		return sum;
    }
}
