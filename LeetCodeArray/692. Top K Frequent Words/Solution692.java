import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution692 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> counter = new HashMap<>();
        for (String word: words) {
            counter.put(word, counter.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<String> minHeap = new PriorityQueue<>(k, 
        		(a,b) -> counter.get(a) == counter.get(b) ? b.compareTo(a) : counter.get(a) - counter.get(b));
        for(String word: counter.keySet()) {
            minHeap.offer(word);
            if (minHeap.size() > k) minHeap.poll();
        }
        
        List<String> res = new ArrayList();
        while (!minHeap.isEmpty()) res.add(minHeap.poll());
        Collections.reverse(res);
        return res;
    }
}
