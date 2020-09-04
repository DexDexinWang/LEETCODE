import java.util.HashMap;
import java.util.Map;

public class Solution1442 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int countTriplets(int[] arr) {
        int n = arr.length; 
        int res = 0;
        for(int i = 0; i < n -1; i++) {
            int xor = arr[i];
            for(int j = i + 1; j < n; j++) {
                xor ^= arr[j];
                if(xor == 0) {
                    res+= (j -i);
                }
            }
        }
        return res;
    }
    
    public int countTriplets1(int[] A) {
        int n = A.length, res = 0, prefix = 0;
        int c, t;
        Map<Integer, Integer> count = new HashMap<>(), total = new HashMap<>();
    
        count.put(0, 1);
    
        for (int i = 0; i < n; ++i) {
            prefix ^= A[i];
            c = count.getOrDefault(prefix, 0);
            t = total.getOrDefault(prefix, 0);
            res += c * i - t;
            count.put(prefix, c + 1);
            total.put(prefix, t + i + 1);
        }
        return res;
    }
}
