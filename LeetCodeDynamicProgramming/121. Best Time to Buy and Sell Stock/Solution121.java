
public class Solution121 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //Bottom-up
    //Linear Secan and check back of the previous elements
    //DP[0] = 0;
    //DP[i] = represent the max profit. price[i] - (lowest Price from 0 to i-1)
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int lowestPrice = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] >= lowestPrice) {
                maxProfit = Math.max(maxProfit, prices[i] - lowestPrice);
            } else {
                lowestPrice = prices[i];
            }
        }
        return maxProfit;
    }
}
