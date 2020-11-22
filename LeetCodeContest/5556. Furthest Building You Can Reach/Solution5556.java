import java.util.PriorityQueue;

public class Solution5556 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] heights = new int[] {14,3,19,3};
		System.out.println(new Solution5556().furthestBuilding(heights,  17, 0));
	}
	
	public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int len = heights.length;
        int[] diff = new int[len];
        for(int i = 1; i < len; i++) {
        	diff[i] = heights[i] > heights[i-1] ? heights[i] - heights[i-1] : 0;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->(b-a));
        int sum = 0;
        for(int i = 0; i < len; i++) {
        	sum += diff[i];
        	maxHeap.offer(diff[i]);
        	if(sum > bricks) {
        		while(ladders != 0 && sum > bricks) {
        			sum-= maxHeap.poll();
        			ladders--;
        		} 
        		if(sum > bricks) {
        			return i - 1;
        		}
        	}
        }
        return len-1;
    }
	
    public int furthestBuilding0(int[] heights, int bricks, int ladders) {
        return countMax(heights, bricks, ladders, 0);
    }
    
    private int countMax(int[] diff, int bricks, int ladders, int index) {
        if(index >= diff.length - 1) {
            return index;
        }
        
        if(diff[index + 1] <= diff[index]) {
            return countMax(diff, bricks, ladders,index + 1);
        } else {
            int currentMax = index;
            if (diff[index + 1] -diff[index] <= bricks){
                currentMax = Math.max(currentMax, countMax(diff, bricks - (diff[index + 1] -diff[index]), ladders, index + 1));
            } 
            if(ladders > 0 ) {
                currentMax = Math.max(currentMax, countMax(diff, bricks, ladders - 1,index + 1));
            } 
            return currentMax;
        }
    }
}
