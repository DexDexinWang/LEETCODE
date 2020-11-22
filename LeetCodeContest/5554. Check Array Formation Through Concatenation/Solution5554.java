import java.util.HashMap;
import java.util.Map;

public class Solution5554 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution5554 s = new Solution5554();
		s.canFormArray(new int[] {85}, new int[][] {{85}});
	}
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        for(int[] piece: pieces) {
            map.put(piece[0],piece);
        }
        int index = 0;
        while(index < arr.length) {
            if(map.containsKey(arr[index])) {
                int[] temp = map.get(arr[index]);
                for(int i = 0; i <temp.length; ) {
                    if(arr[index++] != temp[i++])  {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        return false;
    }
}
