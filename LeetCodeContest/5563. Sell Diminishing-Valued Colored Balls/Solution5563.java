import java.util.PriorityQueue;

public class Solution5563 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution5563().maxProfit(new int[] {1000000000},1000000000));
	}
    public int maxProfit(int[] inventory, int orders) {
    	int total = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->(inventory[b]-inventory[a]));
        for(int i = 0; i < inventory.length; i++) {
            maxHeap.offer(i);
            total+= inventory[i];
        }
        long max = 0;
        if(orders >= total) {
    		max = (long)orders*(long)(orders + 1) /2;
    	} else {
            for(int i = 0; i < orders; i++) {
                if(!maxHeap.isEmpty()) {
                    int index = maxHeap.poll();
                    if(inventory[index] != 0) {
                        max+= inventory[index];
                        inventory[index]--;
                        maxHeap.offer(index);
                    }
                }
            }
        }
        return (int)(max % (Math.pow(10,9) + 7));
    }
}
