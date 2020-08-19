import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


class SnakeGame {

	    /** Initialize your data structure here.
	        @param width - screen width
	        @param height - screen height 
	        @param food - A list of food positions
	        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
	    char[][] map;
	    List<Body> body;
	    int size = 0;
	    public SnakeGame(int width, int height, int[][] food) {
	        map = new char[height][width];
	        for(int i = 0; i < height; i++) {
	        	Arrays.fill(map[i], 'E');
	        }
	        for(int[] f : food) {
	            int x = f[0];
	            int y = f[1];
	            map[x][y] = 'F';
	        }
	        map[0][0] = 'S';
	        body = new LinkedList<>();
	        body.add(new Body(0,0));
	    }
	    
	    /** Moves the snake.
	        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
	        @return The game's score after the move. Return -1 if game over. 
	        Game over when snake crosses the screen boundary or bites its body. */

	    public int move(String direction) {
	        Map<String,int[]> directions =new HashMap<>();
	        directions.put("U", new int[]{-1, 0});
	        directions.put("L", new int[]{0, -1});
	        directions.put("R", new int[]{0, 1});
	        directions.put("D", new int[]{1, 0});
	        int[] dir = directions.get(direction);
	        int newX = body.get(0).x + dir[0];
	        int newY = body.get(0).y + dir[1];
	        if(isDead(newX, newY)) return -1;
	        if(map[newX][newY] == 'F') {
	            body.add(0, new Body(newX, newY));
	            size++;
	        } else {
	            Body tail = body.get(body.size()-1);
	            map[tail.x][tail.y]= 'E';
	            body.remove(body.size()-1);
	            body.add(0,new Body(newX, newY));
	        }
	        map[newX][newY] = 'S';
	        return size;
	    }
	    
	    private boolean isDead(int x , int y) {
	        return !(x >= 0 && x < map.length && y >= 0 && y < map[0].length && (map[x][y] == 'E' || map[x][y] == 'F'));
	    } 
	    
	    class Body{
	        int x;
	        int y;
	        public Body(int x, int y) {
	            this.x = x;
	            this.y = y;
	        }
	    }
	}

