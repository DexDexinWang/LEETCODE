import java.util.List;

/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Aug 18, 2017 1:13:05 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

public class Solution339 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int depthSum(List<NestedInteger> nestedList) {
        return getResult(nestedList,1);
    }
    
    private int getResult(List<NestedInteger> a, int b)
    {
        int sum = 0;
        for(NestedInteger c: a)
        {
            sum+= c.isInteger()? c.getInteger()*b: getResult(c.getList(),b+1);
        }
        return sum;
    }

}



// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
 interface NestedInteger {

// @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();
 
     // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();
 
     // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return null if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
  }
