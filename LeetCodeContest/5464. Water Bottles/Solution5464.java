
public class Solution5464 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        while(numBottles>= numExchange) {
            int newBottles = numBottles / numExchange;
            res += newBottles;
            numBottles = newBottles + numBottles % numExchange;
        }
        return res;
    }
}
