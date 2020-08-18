
public class Solution121 {

    //Bottom-up
    //Linear Secan and check back of the previous elements
    //DP[0] = 0;
    //DP[i] = max profit form prices[0] to prices[i]
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
