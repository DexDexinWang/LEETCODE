import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution1203 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> test = new LinkedList<>();
		int[][] temp = new int[][]{{},{6},{5},{6},{3,6},{},{},{}};
		for(int i = 0; i < 8; i++) {
			test.add(new LinkedList<>());
			for(int item: temp[i]) {
				test.get(i).add(item);
			}
		}
		System.out.println(Arrays.toString(new Solution1203().sortItems(8, 2, new int[] {-1,-1,1,0,0,1,0,-1}, test)));
	}
    //Topological Ordering + groups
    class Group {
        int total;
        List<Integer> items;
        List<Integer> output;
        int indegree;
        public Group(){
            total = 0;
            indegree = 0;
            items = new LinkedList<>();
            output = new LinkedList<>();
        }
        
    }
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
             //Add count to groups and single item;
        Map<Integer, Group> groups = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int gid = getGroupId(group, i);
            groups.putIfAbsent(gid, new Group());
            groups.get(gid).items.add(i);
        }
        
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Set<Integer>> ggraph = new HashMap<>();
        int[] count = new int[n];
        for(int i = 0; i < n; i++) {
            int to = i;
            for(Integer from: beforeItems.get(i)) {
                graph.putIfAbsent(from, new LinkedList<>());
                graph.get(from).add(to);
                count[to]++;
                int gid = getGroupId(group,to);
                groups.get(gid).total++;
                
                int gid2 = getGroupId(group, from);
                ggraph.putIfAbsent(gid2, new HashSet<>());
                ggraph.get(gid2).add(gid);
            }
        }
        
        //put in-degree is 0 into group
        Deque<Integer> que = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(count[i] == 0) {
                que.offerFirst(i);
                if(group[i] != -1) {
                	groups.get(group[i]).output.add(i);
                }
            }
        }
        
        int index = 0;
        while(!que.isEmpty()) {
            int curr = que.pollFirst();
            int gid = group[curr];
            index++;
            //remove in degrees
            if(graph.containsKey(curr)){
                for(int next: graph.get(curr)){
                    count[next]--;
                    int ngid = getGroupId(group,next);
                    groups.get(ngid).total--;
                    if(count[next] == 0) {
                    	que.offerLast(next);
                        groups.get(ngid).output.add(next);
                        if(groups.get(ngid).total== 0) {
                        	if(ggraph.containsKey(ngid)) {
                        		for(int neiborGroup: ggraph.get(ngid)) {
                        			groups.get(neiborGroup).indegree--;
                        			if(groups.get(neiborGroup).indegree == 0) {
                        				
                        			}
                        		}
                        	}
                        }
                    }
                }
            }
        }
        int[] res = new int[n];
        if(index == n) {
            return res;
        } else {
            return new int[0];
        }
    }
    
    private int getGroupId(int[] group, int i) {
    	return group[i] < 0 ? (-1)*i: group[i];
    }
     
}
