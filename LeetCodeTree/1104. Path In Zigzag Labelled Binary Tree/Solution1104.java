import java.util.LinkedList;
import java.util.List;

public class Solution1104 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Solution1104().pathInZigZagTree(14);
	}
	
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new LinkedList<>();
        int temp = label;
        int max = 1;
        while(temp != 0) {
            temp >>= 1;
            max <<= 1;
        }
        
        
        while(label != 1) {
            res.add(label);    
            label = (max >> 1) - 1 + (max - label); 
            label = label / 2;
            max >>= 1;
        }
        res.add(1);
        return res;
    }
}
