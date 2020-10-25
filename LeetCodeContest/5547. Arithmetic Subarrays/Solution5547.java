import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution5547 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new LinkedList<>();
        int len = l.length;
        for(int i = 0; i < len; i++) {
            int subLen = r[i] - l[i] + 1;
            int[] temp = new int[subLen];
            System.arraycopy(nums, l[i], temp, 0, subLen); 
            Arrays.sort(temp);
            res.add(traverseSubArray(temp));
        }
        return res;
    }
    
    public Boolean traverseSubArray(int[] temp){
        if(temp.length <=2) return true;
        int diff = temp[1] - temp[0];
        for(int i = 2; i < temp.length; i++) {
            if(temp[i] - temp[i-1] != diff) {
                return false;
            }
        }
        return true;
    }
}
