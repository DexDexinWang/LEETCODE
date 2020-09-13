import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Synonym {
	// Assume input is valid words
	// a word
	// string " a:b c:d e:f f:g : b:c" a b c d

	// build graph, DFS with memorization
	// Map<string, Set<String>>
	// every single word as key, all its dependency as adjacency set
	// O(n) and n is number of unique words
	public static List<String> getSynonyms(String str, String word) {
		Map<String, String> map = new HashMap<>();
		List<String[]> edges = getAllString(str, map);
		for (String[] edge : edges) { // union
			String p1 = find(edge[0], map);
			String p2 = find(edge[1], map);
			if (!p1.equals(p2)) {
				map.put(p1, p2);
			}
		}
		List<String> res = new LinkedList<>();
		String targetGroup = map.get(word);
	    for(Map.Entry<String,String> entry: map.entrySet()) {
	        if(entry.getKey().equals(word)){
	          continue;
	        }
	        if(find(entry.getValue(),map).equals(targetGroup)) {
	          res.add(entry.getKey());
	        }
	      }
		return res;
	}

	public static String find(String str, Map<String, String> map) {
		if (!map.get(str).equals(str)) {
			map.put(str, find(map.get(str), map));
		}
		return map.get(str);
	}

	public static List<String[]> getAllString(String str, Map<String, String> map) {
		List<String[]> edges = new LinkedList<>();
		for (String s : str.split(" ")) {
			s = s.replaceAll(" ", "");
			if (!s.isEmpty()) {
				String[] temp = parseString(s);
				if (!map.containsKey(temp[0])) {
					map.put(temp[0], temp[0]);
				}
				if (!map.containsKey(temp[1])) {
					map.put(temp[1], temp[1]);
				}
				edges.add(temp);
			}
		}
		return edges;
	}

	public static String[] parseString(String str) {
		int index = str.indexOf(":");
		String[] output = new String[2];
		output[0] = str.substring(0, index);
		output[1] = str.substring(index + 1);
		return output;
	}

	public static void main(String[] args) {

		String str = "advice:counsel counsel:suggestion suggestion:advice activity:briskness briskness:liveliness";
		String word = "advice";

		List<String> result = getSynonyms(str, word);
		for (String output : result) {
			System.out.println("res: " + output);
		}
	}
}
