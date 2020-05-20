import java.util.ArrayList;
import java.util.List;

public class LeftmostColumnWithAtLeastAOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
            List<Integer> dimensions = binaryMatrix.dimensions();
            int rows = dimensions.get(0);
            int cols = dimensions.get(1);
            int row = 0;
            int col = cols - 1;
            int leftMost = -1;
            while (row < rows && col >= 0) {
                    if (binaryMatrix.get(row, col) == 1) {
                        leftMost = col;
                        col--;
                    } else {
                        row++;
                    }

            }
            return leftMost;
    }
}

	class BinaryMatrix {
	     public int get(int row, int col) {return 0;}
	     public List<Integer> dimensions() {
	    	 return new ArrayList<Integer>();
	     }
	};
