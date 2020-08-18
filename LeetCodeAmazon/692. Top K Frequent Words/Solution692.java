import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution692 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for(String word: words) {
            count.put(word, count.getOrDefault(word,0) + 1);
        }
        
        PriorityQueue<PQEntry> minHeap = new PriorityQueue<>((a,b)->
                    (a.count == b.count ? b.str.compareTo(a.str): a.count - b.count));
        for(Map.Entry<String, Integer> entry : count.entrySet()) {
            minHeap.offer(new PQEntry(entry.getKey(),entry.getValue()));
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        List<String> res = new LinkedList<>();
        for(int i = 0; i < k; i++) {
            res.add(0,minHeap.poll().str);
        }
        return res;
    }
    
    class PQEntry{
        String str;
        int count;
        public PQEntry(String str, int count) {
            this.str = str;
            this.count = count;
        }
    }
    
}
