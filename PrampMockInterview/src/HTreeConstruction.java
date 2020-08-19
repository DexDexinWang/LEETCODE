import java.util.Deque;
import java.util.LinkedList;

public class HTreeConstruction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**

	depth 1

	H

	depth = 2

	H H
	 H
	H H

	Dpeth 1? "|","-","|"  


	-    x1 = 0, x2 = 1
	|    x1 =0, y1= 1, y2 = -1
	|    x2 = 1, y1 =  1, y2 = -1
	*/

	static void drawLine(int x1, int x2, int y1, int y2) 
	{
	    //Horizontal line x1 = -1, x2 = 1, y1 =0, y2 = 0
	    //Left vertical line x1 = -1, x2 =-1, y1= 1, y2= -1
	    //JRight vertical line x1 = 1, x2 = 1, y1= 1, y2= -1
	}

	//BFS + level check
	//Initial Status: only one H that will be exneded
	//Generated Rule for the expended node: get 4 coordinators in the four courners as new center to draw H
	//Termination rules: will be depth levels
	static void drawHTree(int depth, int length, int x, int y)
	{
	  Deque<HStructure> que = new LinkedList<>();
	  que.offerLast(new HStructure(x, y, length));
	  int currentDepth = 1;
	  while(currentDepth <= depth) {
	    int size = que.size();
	    for(int i = 0; i < size; i++) {
	    	HStructure curr = que.pollFirst();
	      drawLine(curr.newX1, curr.newX2, curr.newY1, curr.newY2);
	      que.offerLast(new HStructure(curr.newX1, curr.newY1, curr.length/2));
	      que.offerLast(new HStructure(curr.newX1, curr.newY2, curr.length/2));
	      que.offerLast(new HStructure(curr.newX2, curr.newY1, curr.length/2));
	      que.offerLast(new HStructure(curr.newX2, curr.newY2, curr.length/2));
	    } 
	    currentDepth++;
	  }
	}

  static class HStructure {
	  int newX1;
	  int newX2;
	  int newY1;
	  int newY2;
	  int length;
	  public HStructure (int x, int y, int length) {
	    this.length = length;
	    int lineSize = length /2;
	  int[][] directions = new int[][]{{lineSize, -lineSize, 0, 0},{-lineSize, -lineSize, lineSize, -lineSize},{lineSize, lineSize, lineSize, -lineSize},};
	  for(int i = 0 ; i < 3; i++) {
	    int newX1 = x + directions[i][0];
	    int newX2 = x + directions[i][1];
	    int newY1 = y + directions[i][2];
	    int newY2 = y + directions[i][3];
	  }
	  
	}
  }
}
