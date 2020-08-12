import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CriticalRouters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numRouters1 = 7;
		int numLinks1 = 7;
		int[][] links1 = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 5}, {5, 6}, {3, 4}};
		System.out.println(getCriticalNodes(links1, numLinks1, numRouters1));
	}

	//Union Find. 
	//Time complexity: O(n*m) where n is the number of vectors, m is the number of edges
	//Space complexity: O(n)
	private static List<Integer> getCriticalNodes(int[][] links, int numLinks, int numRouters) {
		List<Integer> list = new LinkedList<>();
		for(int i = 0; i < numRouters; i++) {
			if(!isConnected(links, numLinks, numRouters, i)) {
				list.add(i);
			}
		}
		return list;
	}
	
	private static boolean isConnected(int[][] links, int numLinks, int numRouters, int target) {
		int[] parent = new int[numRouters];
		for(int i = 0; i < numRouters; i++) {
			parent[i] = i;
		}
		for(int i = 0; i < links.length; i++) {
			int a = links[i][0];
			int b = links[i][1];
			if(a == target || b == target) continue;
			int pa = find(parent, a);
			int pb = find(parent,b);
			if(pa != pb) {
				parent[pa] = parent[pb];
			}
		}
		Set<Integer> groups = new HashSet<>();
		for(int i = 0; i < numRouters; i++) {
			groups.add(find(parent, i));
		}
		return groups.size() == 2;
	}
	
	private static int find(int[] parent, int index) {
		if(parent[index] != index) {
			parent[index] = find(parent, parent[index]);
		}
		return parent[index];
	}
}
