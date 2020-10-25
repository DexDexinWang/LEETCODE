import java.util.Arrays;

public class Solution5156 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.deepToString(new Solution5156().matrixRankTransform(new int[][] {{20,-21,14},{-19,4,19},{22,-47,24},{-19,4,19}})));
	}
	public int[][] matrixRankTransform(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int size = rowLen * colLen;
        int[][] sortedArray = new int[size][3];
        
        int index = 0;
        for(int i = 0 ; i < rowLen; i++) {
            for(int j = 0; j < colLen; j++) {
                sortedArray[index++] = new int[] {i,j, matrix[i][j]};
            }
        }
        Arrays.sort(sortedArray,(a,b) -> (a[2] - b[2]));
        /*
        int[] rowMax = new int[rowLen];
        int[] colMax = new int[colLen];    
        */
        int[][] res = new int[rowLen][colLen];
        for (int[] row: res)
            Arrays.fill(row, 1);
        for(int[] temp : sortedArray) {
            int currX = temp[0];
            int currY = temp[1];
            setMax(currX, currY, rowLen, colLen, res, matrix);
            /*
            res[currX][currY] = Math.max(rowMax[currX], rowMax[currY]) + 1;
            rowMax[currX] = res[currX][currY]; 
            colMax[currY] = res[currX][currY];
            */
        }
        
        return res;
    }
    
    public void setMax(int currX, int currY, int rowLen, int colLen, int[][] res, int[][] matrix) {
        int maxX = 1;
        for(int i = 0; i < colLen; i++) {
            maxX = Math.max(maxX, res[currX][i] + (matrix[currX][currY] > matrix[currX][i] ? 1 : 0));
        }
        int maxY = 1;
        for(int i = 0; i < rowLen; i++) {
            maxY = Math.max(maxY, res[i][currY] + (matrix[currX][currY] > matrix[i][currY] ? 1 : 0));
        }
        res[currX][currY] = Math.max(maxX, maxY);
    }
}
