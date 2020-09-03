import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1356 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution1356 test = new Solution1356();
		System.out.println(Arrays.toString(test.sortByBits(new int[]{1,2,3,4,5})));
		
	}
	
    public int[] sortByBits(int[] arr) {
    	int[] res = Arrays.stream(arr).boxed().sorted((a,b) -> (countOnes(a) == countOnes(b) ? a - b : countOnes(a) - countOnes(b))).mapToInt(x -> x).toArray();
        return res;
    }
    
    public int countOnes(int num) {
        int res = 0;
        while(num != 0) {
            res += ((num % 2) == 1) ? 1 : 0;
            num >>=1;
        }
        return res;
    }
}
