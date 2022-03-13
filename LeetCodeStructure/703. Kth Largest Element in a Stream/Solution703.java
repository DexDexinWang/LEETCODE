import java.util.PriorityQueue;

public class Solution703 {

	public static void main(String[] args) {
		KthLargest kthLargest = new KthLargest(3, new int[] {4, 5, 8, 2});
		System.out.println(kthLargest.add(3));
		System.out.println(kthLargest.add(5));
		System.out.println(kthLargest.add(10));
		System.out.println(kthLargest.add(9));
		System.out.println(kthLargest.add(4));

	}

	
	

}

class KthLargest {
    /*
    Solve the problem with PriorityQueue 
    Time complexity:O(logn) for add method. O(1) find kth largest. 
    */

    int size;
    PriorityQueue<Integer> minHeap;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>(k + 1);
        size = k;
        for(int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        if(minHeap.size() > size) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}


