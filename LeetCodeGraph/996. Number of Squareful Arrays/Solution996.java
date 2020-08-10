import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution996 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution996().numSquarefulPerms(new int[] {1,17,8}));
	}
    boolean[] visited;
    List<Integer> path;
    int res;
    public int numSquarefulPerms(int[] A) {
        Arrays.sort(A);
        int len = A.length;
        visited = new boolean[len];
        path = new LinkedList<>();
        res = 0;
        dfs(A);
        return res;
    }
    
    private boolean isSquarefull(int a, int b) {
        int s = (int)Math.sqrt(a + b);
        return s*s == a + b;
    }
    
    private void dfs(int[] A) {
        if(path.size() == A.length) {
            res++;
            return;
        }
        for(int i = 0; i < A.length; i++) {
        	if(visited[i]) continue;
            int curr = A[i];
            if(i > 0 && A[i - 1] == curr && !visited[i-1]) continue;
            if(path.size() > 0 && !isSquarefull(path.get(path.size() -1),curr)) continue;
            visited[i] = true;
            path.add(curr);
            dfs(A);
            visited[i] = false;
            path.remove(path.size()-1);
        }
    }
}
