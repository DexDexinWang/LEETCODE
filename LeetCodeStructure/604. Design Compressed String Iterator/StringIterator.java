/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Jun 11, 2017 10:37:02 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Design and implement a data structure for a compressed string iterator. It should support the following operations: next and hasNext.

The given compressed string will be in the form of each letter followed by a positive integer representing the number of this letter existing in the original uncompressed string.

next() - if the original string still has uncompressed characters, return the next letter; Otherwise return a white space.
hasNext() - Judge whether there is any letter needs to be uncompressed.

Note:
Please remember to RESET your class variables declared in StringIterator, as static/class variables are persisted across multiple test cases. Please see here for more details.

Example:

StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");

iterator.next(); // return 'L'
iterator.next(); // return 'e'
iterator.next(); // return 'e'
iterator.next(); // return 't'
iterator.next(); // return 'C'
iterator.next(); // return 'o'
iterator.next(); // return 'd'
iterator.hasNext(); // return true
iterator.next(); // return 'e'
iterator.hasNext(); // return false
iterator.next(); // return ' ' 
 */

import java.util.List;
import java.util.ArrayList;

public class StringIterator 
{
	List<Character> chars = new ArrayList<>();
	List<Integer> counts = new ArrayList<>();
	int pointer=0;
    public StringIterator(String compressedString) 
    {
    	int i=0;
    	while(i<compressedString.length())
    	{
    		chars.add(compressedString.charAt(i));
    		int j =i+1;
    		while(j<compressedString.length() && Character.isDigit(compressedString.charAt(j))) j++;
    		counts.add(Integer.parseInt(compressedString.substring(i+1,j)));
    		i=j;
    	}
    }
    
    public char next() 
    {
        if(!hasNext()) return ' ';
        char result = chars.get(pointer);
        counts.set(pointer,counts.get(pointer)-1);
        if(counts.get(pointer)==0) pointer++;
        return result;
    }
    
    public boolean hasNext() 
    {
        return pointer<chars.size();
    }
}
