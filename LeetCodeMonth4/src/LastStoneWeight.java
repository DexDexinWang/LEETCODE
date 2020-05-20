import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	   //Solve the problem with Max Priority Queue.
    //if PQ.size >= 2, Make a loop to get 2 maximum stones and samsh it together. if remaining, insert. Otherwsie, do nothing.
    public int lastStoneWeight(int[] stones) {
        if(stones == null) {
            return 0;
        } else if (stones.length == 1) {
            return stones[0];
        } else {
            PriorityQueue<Integer> maxPQ = new PriorityQueue<>(stones.length, Collections.reverseOrder());
            for(int stone: stones) {
                maxPQ.offer(stone);    
            }
            while(maxPQ.size() >= 2) {
                int remaining = Math.abs(maxPQ.poll() - maxPQ.poll());
                if (remaining != 0) {
                    maxPQ.offer(remaining);
                }
            }
            return maxPQ.size() == 0 ? 0 : maxPQ.poll();
        }
    }
    //Time complexity O(n*logn) where n is the size of stones
    //Space complexity O(n) where n is the size of stones

}
