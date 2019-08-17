import integer.RandomInteger;

public class Solution29 {
	
	public static void main(String[] args) 
	{
		//System.out.println(divide(-2147483648,-1));
		System.out.println(divide2(10,3));
		//System.out.println(divide(RandomInteger.range(),RandomInteger.range()));
	}
	
	//Version 1: dividend keep subtracting divisor until divisor is bigger than dividend. Then the number of subtraction (Quotient) is the final result. 
	//Potential Problem: Sign for negative inputs and Integer.MIN or Integer.MAX values
    public static int divide(int dividend, int divisor) {
    	//check special cases and overflow result.
    	if (divisor == 1) {
    		return dividend;
    	}
    	if (dividend == divisor) {
    		return 1;
    	}
    	if (divisor == -1) {
    		if (dividend == Integer.MIN_VALUE) {
    			return Integer.MAX_VALUE;
    		} else {
    			return -dividend;
    		}
    	}
    	if (divisor == Integer.MIN_VALUE) return 0;
    	
    	//check regular cases. 
        int sign = ((dividend < 0) ^ (divisor <0)) ? -1 : 1;
        int quotient = 0;
        if (dividend > 0 ) {
        	dividend *= -1;
        }
        if (divisor > 0) {
        	divisor *= -1;
        }
        if (divisor == Integer.MIN_VALUE) return 0;
        
        while (dividend <= divisor) {
        	dividend -= divisor;
        	if(quotient < Integer.MAX_VALUE) {
        		quotient ++;
        	}
        }
        return quotient * sign;
    }
    //Time complexity: O(dividend);
    //Space complexity: O(1); 
    
    //Version 2: dividend = quotient * divisor + remainder
    public static int divide2(int dividend, int divisor) {
    	//check special cases and overflow result.
    	if (divisor == 1) {
    		return dividend;
    	}
    	if (dividend == divisor) {
    		return 1;
    	}
    	if (divisor == -1) {
    		if (dividend == Integer.MIN_VALUE) {
    			return Integer.MAX_VALUE;
    		} else {
    			return -dividend;
    		}
    	}
    	if (divisor == Integer.MIN_VALUE) return 0;
    	
    	//check regular cases. 
        boolean sign = ((dividend < 0) ^ (divisor <0));
        int quotient = 0;
        
        if (divisor<0) divisor= -divisor;
        // trick to avoid overflow when using -dividend
        if (dividend==Integer.MIN_VALUE){
            quotient= 1;
            dividend+= divisor;
        }
        
        if (dividend<0) dividend= -dividend;
        // find max power of 2 not causing overflow for: divisor * 2^k
        int k= 0; 
        //find maximum k;
        while(divisor<<k+1 > 0 && divisor<<k+1 < dividend) {
        	k++;
        }
        // find quotient as a sum of powers of 2
        while(dividend>=divisor) {
            if (dividend >= divisor<<k){
                dividend-= divisor<<k;
                quotient += 1<<k;
            }
            k--;
        }
        return sign ? -quotient : quotient;
    }
    //Time complexity: O(31) = O(1); 
    //Space complexity:O(1);
}
