import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution249 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new LinkedList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String s : strings) {
            String key = getShiftValue(s);
            map.putIfAbsent(key, new LinkedList<>());
            map.get(key).add(s);
        }
        for(Map.Entry<String,List<String>> entry: map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
    
    public String getShiftValue(String str){
        if(str.length() == 0) return "0";
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < str.length(); i++) {
            int temp = 0;
            temp = str.charAt(i) - str.charAt(i-1);
            if(temp < 0) {
                temp = temp + 26;
            }
            
            sb.append((temp < 10 ? "0": "") + String.valueOf(temp));
        }
        return sb.toString();
    }

}
