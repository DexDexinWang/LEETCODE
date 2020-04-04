import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	/**
	 * Write an algorithm to determine if a number is "happy".

		A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
		
		Example: 
		
		Input: 19
		Output: true
		Explanation: 
		12 + 92 = 82
		82 + 22 = 68
		62 + 82 = 100
		12 + 02 + 02 = 1
	 * */
	public static void main(String[] args) {
		int n = 19;
		System.out.println(isHappy(n));

	}

	//brute force 
	//1. check corner cases
	//2. create a while loop to check the number was appeared before. Yes, return false. No, add number and check it again.
	//3.1. create an other loop to add each squared digits as an integer result. 
	//3.1.1. check the integer is overflow. (not necessary, because 32 * 9^2 is far smaller than Math.MAX_VALUE;
	//3.2. check integer result is one or not. 
    public static boolean isHappy(int n) {
    	if (n == 0) {
    		return false;
    	} else if (n == 1) { 
    		return true;
    	}
    	Set<Integer> set = new HashSet<>();
    	while (set.add(n)) {
    		int temp = 0;
    		while (n != 0) {
    			temp += Math.pow(n % 10, 2);
    			n = n / 10;
    		}
    		if (temp == 1 ) {
    			return true; 
    		}else {
    			n = temp;
    		}
    	}
    	return false;
    }
    //Time complexity O(1)      32 * 9^2  < 3200. => 4 digits     outside smaller than 3200.  4 *3200.
    //Space complexity O(1) 	the size of hash map < 3200.
}
