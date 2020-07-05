import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution1387 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(new Solution1387().getKth1(12, 15, 2));
	}

    //Get Kth element
    public int getKth(int lo, int hi, int k) {
        PriorityQueue<Integer[]> minHeap = new PriorityQueue<Integer[]>(
        (Integer[] info0, Integer[] info1) -> info0[0].equals(info1[0]) ? info1[1] - info0[1] : info1[0] - info0[0]);
        for(int i = lo; i <=hi;i++) {
            int power = 0, curr =i;
            while(curr !=1) {
                curr = curr % 2 == 0 ? curr / 2 : curr * 3 + 1;
                power++;
            }
            minHeap.offer(new Integer[]{power, i});
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.poll()[1];
    }
    
    
    //Get Kth element
    public int getKth1(int lo, int hi, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        count.put(1,0);
        count.put(2,1);
        PriorityQueue<Integer[]> minHeap = new PriorityQueue<Integer[]>(
        (Integer[] info0, Integer[] info1) -> info0[0].equals(info1[0]) ? info1[1] - info0[1] : info1[0] - info0[0]);
        for(int i = lo; i <=hi;i++) {            
            minHeap.offer(new Integer[]{dfsCheckCount(i,count), i});
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.poll()[1];
    }
    
    public int dfsCheckCount(int curr, Map<Integer, Integer> map){
        if(map.containsKey(curr)) {
            return map.get(curr);
        }
        map.put(curr, 1 + dfsCheckCount((curr & 1) == 0 ? curr / 2 : curr * 3 + 1, map));
        return map.get(curr);
    }
}
