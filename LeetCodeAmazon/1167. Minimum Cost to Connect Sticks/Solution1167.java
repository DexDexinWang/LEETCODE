import java.util.PriorityQueue;
import java.util.Queue;

public class Solution1167 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    //In order to save minimize the cost. 
    //Each time I could only combine the 2 minimum numbers untile there is only one number
    public int connectSticks(int[] sticks) {
        if(sticks == null || sticks.length <= 1) {
            return 0;
        }
        Queue<Integer> que = new PriorityQueue<>();
        for(Integer num: sticks) {
            que.offer(num);
        }
        int cost = 0;
        while (que.size() >= 2) {
            int sum = que.poll() + que.poll();
            que.offer(sum);
            cost += sum;
        }
        return cost;
    }
    //Time complexity: O(n + n*logn)  
    //Space complexity: O(n)

}
