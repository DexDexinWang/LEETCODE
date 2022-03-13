import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution721 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<String>> map = new HashMap<>();
        for(List<String> list : accounts) {
            String name = list.get(0);
            map.putIfAbsent(name, new List<>());
            for(int i = 1; i < list.size(); i++) {
                map.get(name).add(list.get(i));    
            }
        }
        
        List<List<String>> res = new LinkedList<>();
        
        for(Map<String,List<String>> entrySet : map.entrySet()) {
            String key = entrySet.getKey();
            List<String> list = entrySet.getValue();
            Collections.sort(list);
            list.add(0, key);
            res.add(list);
        }
        return res;
    }
}
