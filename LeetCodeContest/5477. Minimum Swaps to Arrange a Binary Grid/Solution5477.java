
public class Solution5477 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution5477().minSwaps(new int[][] {{0,0,1},{1,1,0},{1,0,0}}));
	}
    //convert grid as int[] 
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] list = new int[n];
        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = n -1 ; j >= 0; j--) {
                if(grid[i][j] == 0) count++;
                else break;
            }
            list[i] = count;
        }
        int steps = 0;
        for(int i = 0; i < n - 1; i++) {
            if(list[i] >= n - 1 - i) continue;
            int target = -1;
            for(int j = i + 1; j < n; j++) {
                if (list[j] >= n - 1 - i) {
                    target = j;
                    break;
                } 
            }
            if (target == -1) return -1;
            for(int k = target ; k > i; k --) {
                steps++;
                swap(list, k, k -1);
            }
        }
        return steps;
    }
    private void swap(int[] list, int a, int b) {
        int temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }
}
