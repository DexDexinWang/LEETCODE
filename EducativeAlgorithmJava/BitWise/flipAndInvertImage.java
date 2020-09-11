
public class flipAndInvertImage {

	  public static int[][] flipAndInvertImage(int[][] arr) {
	      for(int i = 0; i < arr.length; i++) {
	        updateRow(arr[i]);
	      }
	      return arr;
	  }

	  public static void updateRow(int[] row) {
	    int len = row.length;
	    int temp = 0;
	    int firstOneIndex = len + 1;
	    for(int i = len - 1; i >= 0; i--) {
	      temp <<= 1;
	      temp |= row[i];
	      if(row[i] == 1)  {
	        firstOneIndex = len - i + 1;
	      } 
	    }
	    int complement = (int)Math.pow(2, firstOneIndex) - 1;
	    int finalNum = temp ^ complement;
	    for(int i = len - 1; i >= 0; i--) {
	      row[i] = finalNum & 1;
	      finalNum >>= 1;
	    }
	  }

	  public static void print(int[][] arr) {
	    for(int i=0; i < arr.length; i++) {
	      for (int j=0; j < arr[i].length; j++) {
	        System.out.print(arr[i][j] + " ");
	      }
	      System.out.println();
	    }
	  }

	  public static void main(String[] args) {
	    int[][] arr = {{1, 0, 1}, {1, 1, 1}, {0, 1, 1}};
	    print(flipAndInvertImage(arr));

	    int[][]arr2 = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
	    print(flipAndInvertImage(arr2));
	  }

}
