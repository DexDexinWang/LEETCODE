
public class MakeSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	  public static int[] makeSquares(int[] arr) {
		    int[] squares = new int[arr.length];
		    int left = 0;
		    int right = arr.length - 1;
		    int index = arr.length - 1;
		    while(index >= 0) {
		      int squareLeft = arr[left] * arr[left];
		      int squareRight = arr[right] * arr[right];
		      if(squareLeft > squareRight) {
		        squares[index--] = squareLeft;
		        left++;
		      } else {
		        squares[index--] = squareRight;
		        right--;
		      }
		    }
		    
		    return squares;
		  }
}
