
public class Solution5607 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution5607 test = new Solution5607();
		System.out.println(test.waysToMakeFair(new int[] {2,1,6,4}));
		System.out.println(test.waysToMakeFair(new int[] {1,1,1}));
	}	
    public int waysToMakeFair(int[] nums) {
        int len = nums.length;
        if(len == 1) return 1;
        int[] preSum = new int[len];
        preSum[0] = nums[0];
        preSum[1] = nums[1];
        for(int i = 2; i < len; i++) {
            preSum[i] =preSum[i-2] + nums[i];
        }
        int sum = 0;
        for(int i = 0; i < len; i++) {
            if(isFair(preSum,nums, len, i)) {
                sum++;
            }
        }
        return sum;
    }
    
    
    private boolean isFair(int[] preSum, int[] nums, int len,  int index) {
        boolean isEvenLen = len % 2  == 0;
        int oddTotal = isEvenLen ? preSum[len - 1] : preSum[len - 2] ;
        int evenTotal = isEvenLen ? preSum[len - 2]: preSum[len - 1];
        boolean isEvenIndex = index % 2 == 0;
        if(isEvenIndex) {
        	return evenTotal - preSum[index] + (index - 1 >= 0 ? preSum[index - 1] : 0) 
                    == oddTotal - (index - 1 >= 0 ? preSum[index - 1] : 0) + preSum[index] - nums[index];
        } else {
        	return oddTotal - preSum[index] + (index - 1 >= 0 ? preSum[index - 1] : 0) 
                    == evenTotal - (index - 1 >= 0 ? preSum[index - 1] : 0) + preSum[index] - nums[index];
        }
    }
}
