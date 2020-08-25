
public class DutchNationalFlagProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	  public static void sort(int[] arr) {
		    int low  = 0;
		    int height = arr.length - 1;
		    for(int i = 0; i <= height;) {
		      if(arr[i] == 0) {
		        swap(arr, i, low);
		        i++;
		        low++;
		      } else if (arr[i]==1) {
		        i++;
		      } else {
		        swap(arr, i, height);
		        height--;
		      }
		    }
		  }
		  public static void swap (int[] arr, int x, int y) {
		    int temp = arr[x];
		    arr[x] = arr[y];
		    arr[y] = temp;
		  }
}
