import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ProductofArrayExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public int numIslands(char[][] grid) {
	        List<Position> islands = new LinkedList<>();
	        for(int i = 0; i <grid.length; i++) {
	            for(int j = 0; j <grid[0].length; j++) {
	                if (grid[i][j] == '1') {
	                    islands.add(new Position(i,j));
	                }
	            }
	        }
	        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
	        int total = 0;
	        for(Position pos: islands) {
	        	if(isVisited[pos.x][pos.y] == false) {
	        		isVisited[pos.x][pos.y] = true;
	        		traverseIsland(pos.x, pos.y, grid, isVisited);
	        		total ++;
	        	}
	        }
	        return total;
	  }
	    
	    public void traverseIsland(int x, int y, char[][] grid, boolean[][] isVisited) {
	        Queue<Position> positions = new LinkedList<>();
	        positions.add(new Position(x,y));
	        while(positions.size() != 0) {
	        	Position currPos = positions.poll();
	        }
	    }
	    
}

	class Position {
	    int x;
	    int y;
	    public Position(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }
	}