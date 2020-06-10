import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution582 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//HashMap + BFS
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> res = new LinkedList<>();
        if(pid == null || pid.size() == 0 || ppid == null || ppid.size() == 0) {
            return res;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < ppid.size(); i++) {
            int parent = ppid.get(i);
            if(!map.containsKey(parent)) {
            	map.put(parent, new LinkedList<>());
            }
            map.get(parent).add(pid.get(i));
        }
        Deque<Integer> queue = new LinkedList<>();
        queue.offerLast(kill);
        while(!queue.isEmpty()) {
        	int size = queue.size();
        	for(int i =0 ; i < size; i++) {
        		int parent= queue.pollFirst();
        		res.add(parent);
        		if(map.containsKey(parent)) {
	        		for(int child : map.get(parent)) {
	        			queue.offerLast(child);
	        		}
        		}
        	}
        }
        return res;
    }
}
