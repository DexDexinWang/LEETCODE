import java.util.LinkedList;
import java.util.List;

public class Solution763 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //Greedy Algorithm, 
    //For character potions from fist occurance to the last occurance,
    //Check all other characters during firstA from lastA and extend lastA.
    //Until all characters from firstA to extended LastA will not appear After LastA.
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new LinkedList<>();
        char[] chars = S.toCharArray();
        int[] lastPosition = new int[26];
        for(int i = 0; i < chars.length; i++) {
            lastPosition[chars[i] - 'a'] = i;
        }
        int start = 0;
        int end = 0;
        for(int i = 0; i < chars.length; i++) {
            end = Math.max(end,lastPosition[chars[i] - 'a']);
            if(i == end) {
                res.add(end-start + 1);
                start = i + 1;
            }
        }
        return res;
    }
}
