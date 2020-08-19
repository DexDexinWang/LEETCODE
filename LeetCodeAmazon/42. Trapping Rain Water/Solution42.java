
public class Solution42 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Solution42().trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1});
	}
    //DP[i] represent that the differnt volumn that is smaller than previous left bar.
    //DP1[i] represnt that the different volumn that is smaller then privous right bar.
    //DP[0] = 0;
    //DP[i] = dp[k] > dp[i] ? dp[k] - dp[i] : 0; where 0 <= k < i
    //DP1[n-1] = 0;
    //DP1[i] = dp[k] > dp[i] ? dp[k] - dp[i] : 0; where i < k <= n-1;
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int len = height.length;
        int leftbar = height[0];
        int rightbar = height[len-1];
        int[] dpLeft = new int[len];
        int[] dpRight = new int[len];
        for(int i = 1; i < len; i++) {
            if(height[i] >= leftbar) leftbar = height[i];
            dpLeft[i] = leftbar - height[i];
            if(height[len-1-i] >= rightbar) rightbar = height[len-1-i]; 
            dpRight[len-1-i] = rightbar - height[len-1-i];
        }
        
        int res = 0;
        for(int i = 0; i < len; i++) {
            res+= Math.min(dpLeft[i] , dpRight[i]);
        }
        return res;
    }
    
    //Two pointers: left and right;
    //Each time just get to the lowerest pointer
    //For left pinter: If height[left] >= leftBar, leftBar = height[left] Otherwise ans+= leftBar - height[left];
    //For right pointer: If height[right] >= rightBar, rightBar = height[right] otherwise ans+= rightBar - height[right];
    public int trap1(int[] height) {
        if(height == null || height.length == 0) return 0;
        int len = height.length;
        int left = 0; 
        int right = len - 1;
        int leftBar = height[0];
        int rightBar = height[len - 1];
        int ans = 0;
        while(left < right){
            if(height[left] < height[right]) {
                if(height[left] > leftBar) leftBar = height[left];
                ans+= leftBar - height[left];
                left++;
            } else {
                if(height[right] > rightBar) rightBar = height[right];
                ans+= rightBar - height[right];
                right--;
            }
        }
        return ans;
    }
}
