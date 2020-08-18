import java.util.HashMap;
import java.util.Map;

public class Solution957 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean lastRound = false;
        while(N > 0) {
            if(!lastRound) {
                int key = convertArray(cells);
                if(map.containsKey(key)) {
                    N = N % (map.get(key) - N);
                    lastRound = true;
                } else {
                    map.put(convertArray(cells), N);
                }
            }
            if(N>0) {
                N--;
                cells = this.OneDayChange(cells);
            }
        }
        return cells;
    }
    
    public int convertArray(int[] cells) {
        int res = 0;
        for(int i = 0; i < cells.length; i++) {
            res <<= 1;
            res |= cells[i];
        }
        return res;
    } 
    
    public int[] OneDayChange(int[] cells) {
        int size = cells.length;
        int[] temp = new int[size];
        temp[0] = 0;
        temp[size - 1] = 0;
        for(int i = 1; i < size - 1; i++) {
            temp[i] = cells[i-1] ^ cells[i+1] ^ 1;
        }
        return temp;
    }
}
