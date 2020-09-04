import java.util.LinkedList;
import java.util.List;

public class Solution401 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution401().readBinaryWatch(1));
	}
	
    final int[] watch = {1,2,4,8,1,2,4,8,16,32};
    public List<String> readBinaryWatch(int num) {
        List<String> res = new LinkedList<>();
        if(num >= watch.length) return res;
        dfsTraverse(0, 0, 0, num, res);
        return res;
    }
    
    public void dfsTraverse(int index, int hours, int mins, int num, List<String> res) {
        if(index >= watch.length) {
            if(num == 0) {
                if(hours < 12 && mins < 60) {
                    if (mins < 10) {
                        res.add(hours + ":0" + mins);
                    } else {
                        res.add(hours+":"+mins);
                    }
                }
            }
            return;
        } else {
            if (index < 4) {
                if(num >= 1) {
                	dfsTraverse(index+1, hours + watch[index], mins, num-1, res);
                }
                dfsTraverse(index+1, hours, mins, num, res);
            } else {
            	if(num >= 1) {
            		dfsTraverse(index+1, hours, mins + watch[index], num-1, res);
            	}
                dfsTraverse(index+1, hours, mins, num, res);
            }
        }
    }
}
