
public class Solution5608 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution5608 test = new Solution5608();
		System.out.println(test.minimumEffort(new int[][] {{1,2},{2,4},{4,8}}));
	}
    //DFS
    int globalMin;
    int len;
    public int minimumEffort(int[][] tasks) {
        globalMin = Integer.MAX_VALUE;
        len = tasks.length;
        boolean[] visited = new boolean[len];
        bfs(tasks, visited, 0, 0, 0);
        return globalMin;
    }
    
    private void bfs(int[][] task, boolean[] visited, int currentSum, int remining, int total) {
        if(total == len) {
            globalMin = Math.min(globalMin,  currentSum);
        }
        bfs(task, visited, currentSum, remining, total);
        for(int i = 0; i < len; i++) {
            if(!visited[i]) {
                visited[i] = true;
                int temp = Math.max(task[i][0],task[i][1]);
                currentSum += temp - remining;
                remining = Math.abs(task[i][0] - task[i][1]) - remining;
                bfs(task, visited, currentSum, remining, total + 1);
                break;
            }
        }
    }
}
