import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class PartitionarrayintoNsubsetswithbalancedsum {

	/**

Give you one sorted array, please put them into n buckets, we need to ensure we get n sub array with approximately equal weights.
Example;
input {1, 2, 3, 4, 5} n = 3
output [[5],[1,4],[2,3]];

		//Time complexity is O(mlogn) space complexity O(n) where m is the lenght of nums, n is the number of given n. 
	 * @param args
	 */
	public static void main(String[] args) {
		List<List<Integer>> result = getPartitionarrayintoNsubsetswithbalancedsum(new int[] {1,2,3,4,5,6,7,8,9,10}, 3);
		System.out.println(result);
	}
	

	public static List<List<Integer>> getPartitionarrayintoNsubsetswithbalancedsum(int[] nums, int n) {
		int[] sums = new int[n];
		List<List<Integer>> res = new LinkedList<>();
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b)-> sums[a] - sums[b]);
		for(int i = 0; i < n; i++) {
			res.add(new LinkedList<>());
			priorityQueue.add(i);
		}
		
		for(int i = nums.length - 1; i >= 0; i--) {
			int index = priorityQueue.poll();
			int num = nums[i]; 
			res.get(index).add(num);
			sums[index] += num;
			priorityQueue.add(index);
		}
		return res;
	}
	
    public static List<List<Integer>> part(int[] T, int n) {
		int[] sums = new int[n];
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return sums[a.intValue()] - sums[b.intValue()];
			}
		});
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			result.add(new ArrayList<>());
			pq.add(i);
		}
		
		for (int i = T.length - 1; i >= 0; i--) {
			int c = pq.poll();
			result.get(c).add(T[i]);
			sums[c] += T[i];
			pq.add(c);
		}
		
		return result;
	}

}
