
public class BestTimetoBuyandSellStockII {

	public static void main(String[] args) {
		BestTimetoBuyandSellStockII test = new BestTimetoBuyandSellStockII();
		test.maxProfit(new int[] {7,6,4,3,1});
		
	}
	
	public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int sum = 0;
        for(int i = 0; i < prices.length - 1; i++) {
            if (prices[i] <= prices[i + 1]) {
                sum += prices[i+1] - prices[i];
            }
        }
        return sum;
    }
}
