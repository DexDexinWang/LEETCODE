import java.util.Arrays;

public class Solution698 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution698 solution = new Solution698();
		System.out.println(solution.canPartitionKSubsets(new int[] {4,3,2,3,5,2,1}, 4));
	}
	
	    public boolean canPartitionKSubsets(int[] nums, int k) {
	        int sum = 0;
	        for(int num : nums) {
	            sum += num;
	        }
	        return k >0 && (sum % k == 0) && canPartition(nums, 0, k, 0, sum /k, new boolean[nums.length]);
	    }
	    
	    private boolean canPartition(int[] nums, int index, int k, int sum, int target, boolean[] visited) {
	        if(k == 1) {
	            return true;
	        }
	        if(sum == target) {
	        	return canPartition(nums, 0, k-1, 0, target, visited);
	        } 
	        for(int i = index; i < nums.length; i++) {
	        	if(!visited[i]) {
	        		visited[i] = true;
	        		
	        		visited[i] = false;
	        	}
	        }
	        
	        return false;
	    }

}
