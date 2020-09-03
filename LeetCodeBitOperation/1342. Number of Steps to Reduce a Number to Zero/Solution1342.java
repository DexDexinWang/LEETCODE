
public class Solution1342 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    // Solution 1. O(2*logn)
    // even >> 1  divide by 2
    // odd minus 1
    public int numberOfSteps1 (int num) {
        int sum = 0;
        while(num != 0) {
            if(num % 2  == 0) {
                num >>=1;
            }else {
                num -=1;
            }
            sum++;
        }
        return sum;
    }
    // Solution 2. O(logn)
    // bit 
    // odd minus 1
    public int numberOfSteps (int num) {
        if(num <= 1) {
            return num;
        }
        int sum = 0;
        for(int offset = 1; offset <= num; offset <<= 1) {
            if((num & offset) == 0) {
                sum +=1;
            } else {
                sum += 2;
            }
        }
        return sum - 1;
    }
}
