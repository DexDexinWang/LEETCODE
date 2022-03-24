import java.util.Arrays;

public class Solution5627 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[] {5,3,1,4,2};
		int[] input1 = new int[] {7,90,5,1,100,10,10,2};
		Solution5627 test = new Solution5627();
		System.out.println(test.stoneGameVII1(input));
	}
	
    public int stoneGameVII1(int[] stones) {
    	int total = Arrays.stream(stones).sum();
        int[] res = bfs(stones, 0, stones.length - 1, true, total);
        return Math.abs(res[0] - res[1]);
    }
    
    public int stoneGameVII(int[] stones) {
    	int total = Arrays.stream(stones).sum();
    	int left = 0; 
    	int right = stones.length -1;
    	boolean isAlice = true;
    	int aliceTotal = 0;
    	int bobTotal = 0;
    	while(right - left + 1 > 2) {
    		if(isAlice) {
    			total -= stones[left] < stones[right] ? stones[left++] : stones[right--];
    			aliceTotal += total;
    		} else {
    			total -= stones[left] >= stones[right] ? stones[left++] : stones[right--];
    			bobTotal += total;
    		}
    		isAlice = !isAlice;
    	}
    	
    	total -= stones[left] < stones[right] ? stones[left++] : stones[right--];
        if(isAlice) {
    		aliceTotal += total;
    	} else {
    		bobTotal +=total;
    	}
        return Math.abs(aliceTotal -bobTotal); 
    }
    
    
    private int[] bfs(int[] stones, int left, int right, boolean isAlice, int total) {
        if(right - left + 1 <= 2) {
        	int smaller = stones[left] < stones[right] ? stones[left] : stones[right];
            return isAlice ? new int[] {total - smaller,0} : new int[] {0, total - smaller};
        }
        int[] temp0 = bfs(stones, left + 1, right, !isAlice, total - stones[left]);
        int[] temp1 = bfs(stones, left, right - 1, !isAlice, total - stones[right]);
        if(isAlice) {
            if(Math.abs(temp0[0] - temp0[1]) >= Math.abs(temp1[0] - temp1[1])) {
            	temp0[0] += total - stones[left];
                return temp0;
            } else {
            	temp1[0] += total - stones[right];
                return temp1;
            }
        } else {
            if(Math.abs(temp0[0] - temp0[1]) < Math.abs(temp1[0] - temp1[1])) {
            	temp0[1] += total - stones[left];
                return temp0;
            } else {
            	temp1[1] += total - stones[right];
                return temp1;
            }
        }
    }
}
