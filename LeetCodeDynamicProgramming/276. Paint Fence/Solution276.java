
public class Solution276 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //DP represent the number of combinations
    //DP[0] = k
    //DP[1] = k*(k-1)
    //DP[i] = (DP[i-2] + DP[i-1])*(k-1)
    public int numWays(int n, int k) {
        if( n== 0 ) return 0;
        else if( n== 1 ) return k;
        
        int same = k;
        int diff = (k-1)*k;
        
        for(int i=2;i<n; i++)
        {
            int temp = diff;
            diff = (same + diff) * (k-1);
            same = temp;
        }
        return same + diff;
    }
}
