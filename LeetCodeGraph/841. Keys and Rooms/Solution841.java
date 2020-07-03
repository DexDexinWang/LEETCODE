import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution841 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    //BFS 
    //1. choose a node to be expended: room 0
    //2. according to expended node to generate new nodes: rooms[0] 
    //3. terminate rule: no node to be expended.
    //To maintain a queue 
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() == 0) return false;
        Deque<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[rooms.size()];
        que.offerLast(0);
        while(!que.isEmpty()) {
            int roomNo = que.pollFirst();
            if(visited[roomNo]) continue;
            visited[roomNo] = true;
            for(int key: rooms.get(roomNo)) {
                que.offerLast(key);
            }
        }
        
        for(int i = 0; i < visited.length; i++) {
            if(!visited[i]) return false;
        }
        return true;
    }
}
