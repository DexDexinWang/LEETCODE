import java.util.LinkedList;
import java.util.List;

public class Solution986 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> temp = new LinkedList<>();
        int i = 0;
        int j = 0; 
        while(i < A.length && j < B.length) {
            int[] a = A[i];
            int[] b = B[j];
            int start = Math.max(a[0], b[0]);
            int end = Math.min(a[1], b[1]);
            if(start <= end) {
                temp.add(new int[]{start, end});
            } 
            if(a[1] < b[1]) {
                i++;
            } else {
                j++;
            }
        }
        int[][] res = new int[temp.size()][2];
        for(int x = 0; x < temp.size(); x++) {
            res[x] = temp.get(x);
        }
        return res;
    }
}
