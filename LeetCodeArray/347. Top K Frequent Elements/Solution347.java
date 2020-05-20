import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution347 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res= new LinkedList<>();
        if (nums== null || nums.length == 0) {
            return res;
        } 
        Map<Integer, Integer> counters = new HashMap<>();
        for(int num : nums) {
            counters.put(num, counters.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Counter> maxHeap = new PriorityQueue<>(counters.size());
        for(Map.Entry<Integer,Integer> set : counters.entrySet()) {
            maxHeap.offer(new Counter(set.getKey(), set.getValue()));
        }
        
        for(int i = 0; i < k; i++) {
            if (maxHeap.size() != 0) {
                res.add(maxHeap.poll().val);
            }
        }
        return res;
    }
	//Time complexity: O(klogn)
	//Space complexity: O(n)

	
	public List<Integer> topKFrequent1(int[] nums, int k) {
        List<Integer> res = null;
        if (nums== null || nums.length == 0) {
            return res;
        } 
        Map<Integer, Integer> counters = new HashMap<>();
        for(int num : nums) {
            counters.put(num, counters.getOrDefault(num, 0) + 1);
        }
        res = new LinkedList<Integer>(counters.keySet());
        Collections.sort(res, (Integer a, Integer b) -> (counters.get(b) - counters.get(a)));
        return res.subList(0, k);
    }
	//Time complexity:O(nlogn)
	//Space complexity:O(n)
}

class Counter implements Comparable<Counter>{
    public Integer val = 0;
    public Integer count = 0;
    public Counter(Integer val, Integer count) {
        this.val = val;
        this.count = count;
    }
    
    @Override
    public int compareTo(Counter another) {
        if (this.count == another.count) {
            return 0;
        } else {
            return this.count < another.count ? 1 : -1;
        }
        
    }
}