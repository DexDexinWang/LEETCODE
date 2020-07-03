import java.util.List;

public class Solution444 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//1. all nubmers should be in boundary. 1 <= x <= n
    //2. all numbers in seq are in correct order. pos[seq[x]] < pos[seq[x+1]] 
    //3. If seq[k] and seq[k - 1]  is the same as org[x] and org[x - 1], it will confirm seq[k-1] is correct. Find n-1 non-duplicated relationships.
	public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        int size = org.length;
        int[] pos = new int[size + 1];
        boolean[] flag = new boolean[size + 1];
        for(int i = 0; i < org.length; i ++) {
            pos[org[i]] = i;
        }
        int count = size - 1; 
        boolean isExist = false;
        for(List<Integer> seq : seqs) {
            for(int i = 0; i < seq.size(); i++) { //ignore the first 
                isExist = true;
                int cur = seq.get(i);
                if(cur <= 0 || cur > size) return false;
                if(i == 0) continue;
                int pre = seq.get(i-1);
                if(pos[pre] >= pos[cur]) {
                    return false;
                } else {
                    if (!flag[cur] && pos[pre] - pos[cur] == -1) {
                        count--;
                        flag[cur] = true;
                    }
                }
                
            }
        }
        return count == 0 && isExist;
    }
	
}
