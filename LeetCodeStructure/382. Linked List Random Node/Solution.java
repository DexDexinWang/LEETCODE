/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Aug 26, 2017 12:57:58 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

import java.util.Map;
import java.util.HashMap;
import generator.ListNode;

public class Solution {
    Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    int count=0;
    public Solution(ListNode head) {
        while(head!=null)
        {
            map.put(count,head.val);
            head=head.next;
            count++;
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() 
    {
        return map.get((int)(Math.random() * ((count) + 1)));
    }
}
