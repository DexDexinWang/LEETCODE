import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution5223 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> res =new ArrayList<>();
        boolean[][] set = new boolean[8][8];
        for(int[] queen: queens) {
           set[queen[0]][queen[1]] = true;
        }
        
        int[][] dirs = new int[][]{{1,1},{1,0},{1,-1},{-1,1},{-1,0},{-1,-1},{0,-1},{0,1}};
        for(int[] dir: dirs) {
            List<Integer> temp= findQueen(king, dir, set);
            if (temp != null) {
                res.add(temp);
            }
        }
        return res;
    }
    
    private List<Integer> findQueen(int[] king, int[] dir, boolean[][] set) {
    	int x = king[0] + dir[0];
    	int y = king[1] + dir[1];
        while(x >= 0 && x <= 7 && y >= 0 && y<=7) {
            if (set[x][y] == true) {
                return Arrays.asList(x,y);
            }
            x = x + dir[0];
            y = y + dir[1];
        }
        return null;
    }
}
    
