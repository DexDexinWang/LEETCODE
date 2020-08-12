import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class TopKFrequentlyMentionedKeywords {

	public static void main(String[] args) {
		int k1 = 2;
		String[] keywords1 = { "anacell", "cetracular", "betacellular" };
		String[] reviews1 = { "Anacell provides the best services in the city", "betacellular has awesome services",
				"Best services provided by anacell, everyone should use anacell", };
		int k2 = 2;
		String[] keywords2 = { "anacell", "betacellular", "cetracular", "deltacellular", "eurocell" };
		String[] reviews2 = { "I love anacell Best services; Best services provided by anacell",
				"betacellular has great services", "deltacellular provides much better services than betacellular",
				"cetracular is worse than anacell", "Betacellular is better than deltacellular.", };
		System.out.println(solve(k1, keywords1, reviews1));
		System.out.println(solve(k2, keywords2, reviews2));
	}
	
	//Count keywords for each comment;
	//Use priority to print out top K keywords
	private static List<String> solve(int k, String[] keywords, String[] reviews) {
		List<String> res = new LinkedList<>();
		Set<String> keys = new HashSet<>(Arrays.asList(keywords));
		Map<String, Integer> count = new HashMap<>();
		for(int i = 0; i< reviews.length; i++) {
			String review = reviews[i];
			Set<String> visited = new HashSet<>();
			for(String word : review.split(" ")) {
				word = word.toLowerCase();
				if(keys.contains(word) && visited.add(word)) {
					count.put(word, count.getOrDefault(word, 0) + 1);
				}
			}
		}
		PriorityQueue<Map.Entry<String,Integer>> maxHeap = new PriorityQueue<>(k,(a,b)->(a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()): a.getValue() - b.getValue()));
		for(Map.Entry<String, Integer> entry: count.entrySet()) {
			maxHeap.add(entry);
			if(maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		while(!maxHeap.isEmpty()) {
			res.add(0,maxHeap.poll().getKey());
		}
		return res;
	}
}
