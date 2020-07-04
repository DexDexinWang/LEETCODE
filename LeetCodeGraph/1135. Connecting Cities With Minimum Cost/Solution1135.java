import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution1135 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] connections = new int[][] {{1,2,5},{1,3,6},{2,3,1}};
		System.out.print(new Solution1135().minimumCost(3, connections));
	}
	
    public int minimumCost(int N, int[][] connections) {
    	Arrays.sort(connections, (int[] a, int[] b) -> (a[2] - b[2]));
        int[] groups = new int[N + 1];
        for(int i = 1; i <= N; i++) groups[i] = i;        
        int countGroup = N;
        int cost = 0;
        
        for(int[] conn: connections){
            int groupA = findGroup(conn[0], groups);
            int groupB = findGroup(conn[1], groups);
            if(groupA != groupB) {
                countGroup--;
                groups[groupA] = groupB;
                cost+= conn[2];
            }
        }
        return countGroup == 1 ? cost: -1;
    }
    
    private int findGroup(int a, int[] groups) {
        if(groups[a] != a){
            groups[a] = findGroup(groups[a], groups);
        }
        return groups[a];
    }
}

