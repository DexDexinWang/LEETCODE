import java.util.PriorityQueue;

public class MinCosttoConnectRopes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] files1 = {8, 4, 6, 12};
		int[] files2 = {20, 4, 8, 2};
		int[] files3 = {1, 2, 5, 10, 35, 89};
		int[] files4 = {2, 2, 3, 3};
		System.out.println(mergeRopes(files1));
		System.out.println(mergeRopes(files2));
		System.out.println(mergeRopes(files3));
		System.out.println(mergeRopes(files4));
	}
	private static int mergeRopes(int[] ropes) {
		if(ropes == null || ropes.length == 0) return 0;
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for(int rope : ropes) {
			minHeap.offer(rope);
		}
		int count = 0;
		while (minHeap.size() > 1) {
			int curr = minHeap.poll() + minHeap.poll();
			count+= curr;
			minHeap.offer(curr);
		}
		return count;
	}
}
