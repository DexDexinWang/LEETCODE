import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class HTreeConstruction1 {

	  
	  class Main {
		  
		  class HTree{
		    int x;
		    int y;
		    int len;
		    public HTree(int x, int y, int len) {
		      this.x = x;
		      this.y = y;
		      this.len = len;
		    }
		    
		    public List<int[]> generateLines() {
		      List<int[]> res = new LinkedList<>();
		      int tempLen = len/2;
		      int x1 = x - tempLen;
		      int x2 = x + tempLen;
		      int y1 = y + tempLen;
		      int y2 = y - tempLen;
		      res.add(new int[]{x1,y,x2,y}); //horizontal line.
		      res.add(new int[]{x1,y1,x1,y2});//left line
		      res.add(new int[]{x2,y1,x2,y2});// right line;
		      return res;
		    }
		    public List<HTree> generateCorners() {
		      List<HTree> res = new LinkedList<>();
		      int tempLen = len/2;
		      int[][] directions = new int[][]{{-1, 1},{-1, -1},{1,1},{1,-1}};
		      for(int i = 0; i < 4; i++) {
		        int newX = x * directions[i][0] + tempLen;
		        int newY = y * directions[i][1] + tempLen;
		        res.add(new HTree(newX,newY, tempLen));
		      }
		      return res;
		    } 
		  }
		  
		  void drawHTree(int x,int y, int length, int depth) {
		    if(length < 0 || depth <= 0) return ;
		    Deque<HTree> que = new LinkedList<>();
		    que.offerLast(new HTree(x,y,length));
		    int currDepth = 0;
		    while(currDepth < depth) {
		      currDepth++;
		      int size = que.size();
		      for(int i = 0; i < size; i++) {
		        HTree curr = que.pollFirst();
		        for(int[] temp: curr.generateLines()) {
		          drawLine(temp[0],temp[1],temp[2],temp[3]);
		        }
		        for(HTree next: curr.generateCorners()) {
		          que.offerLast(next);
		        }
		      }
		    }
		  }
		  
		  void drawLine(int x1, int y1, int x2, int y2) {
		    System.out.println("");
		  }
		  
		  public void main( String args[] ) {
		    System.out.println( "Practice makes Perfect!" );
		  }
		}
}
