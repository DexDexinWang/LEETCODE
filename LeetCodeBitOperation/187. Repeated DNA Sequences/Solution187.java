import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution187 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        List<String> res = new LinkedList<>();
        if(n < 10) {
            return res;
        }
        int left =0;
        int right = 0; 
        Map<String,Integer> count = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        while(right < n) {
            sb.append(s.charAt(right));
            if(sb.length() == 10) {
                String temp = sb.toString();
                count.put(temp, count.getOrDefault(temp,0) + 1);
                if(count.get(temp) == 2) {
                    res.add(temp);
                }
                sb.deleteCharAt(0);
                left++;
            }
            right++;
        }
        return res;
    }
}
