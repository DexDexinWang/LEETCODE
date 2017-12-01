/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Aug 23, 2017 12:50:27 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class TwoSum {
    Set<Integer> sums;
    Set<Integer> nums;
    /** Initialize your data structure here. */
    public TwoSum() {
        sums= new HashSet<Integer>();
        nums= new HashSet<Integer>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(nums.contains(number))
        {
            sums.add(number*2);
        }
        else
        {
        	Iterator<Integer> iter = nums.iterator();
            while(iter.hasNext())
            {
                sums.add(iter.next() + number);
            }
            nums.add(number);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) 
    {
        if(sums.contains(value))  return true;
        else return false;
    }
}


/*
class TwoSum {
    Map<Integer,Integer> map;
    
    TwoSum()
    {
        map = new HashMap<Integer,Integer>();
    }
    // Add the number to an internal data structure.
	public void add(int number) 
    {
        if(map.containsKey(number))
        {
            map.put(number,2);
        }
        else
        {
            map.put(number,1);
        }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) 
    {
        Iterator<Integer> iter= map.keySet().iterator();
        while(iter.hasNext())
        {
            int num1 = iter.next();
            int num2 = value - num1;
            if(map.containsKey(num2))
            {
                if( num1!=num2 || map.get(num2)==2)
                {
                    return true;
                }
            }
        }
        return false;
	}
}

 */
