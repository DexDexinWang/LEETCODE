import java.util.PriorityQueue;

public class Solution1387 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(new Solution1387().getKth(118, 974, 825));
	}

    public int getKth(int lo, int hi, int k) {
        PriorityQueue<Integer[]> minHeap = new PriorityQueue<Integer[]>(
        (info0, info1) -> info0[0] == info1[0] ? info0[1] - info1[1] : info0[0] - info1[0]);
        for(int i = lo; i <=hi;i++) {
            int power = 0, curr =i;
            while(curr !=1) {
                curr = curr % 2 == 0 ? curr / 2 : curr * 3 + 1;
                power++;
            }
            minHeap.offer(new Integer[]{power, i});
        }
        for(int i = 1; i < k; i++) {
        	minHeap.poll();
        }
        return minHeap.poll()[1];
    }
}
