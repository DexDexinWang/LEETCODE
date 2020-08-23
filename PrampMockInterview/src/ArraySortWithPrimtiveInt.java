import java.util.Arrays;

public class ArraySortWithPrimtiveInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(sort(new int[]{-1, 2, 5,1 ,0})));
		 System.out.println(getMinDiff(new int[]{1, 5, 10, 15}));//  1  5 15 10 =>9
	}
	
	//Time complexity: O(nlogn) quick sort ->Space complexity:O(n)  in the sort process, we can change the compareTo rule.
	  //Second, sort them.
	  //Time comepxltiy: O(n+ nlogn)
	  public static int[] sort(int[] A) {

	    return Arrays.stream(A)//stream != array
	    .boxed()//Integer.valueOf(i)
	    .sorted((a,b) -> Math.abs(a) == Math.abs(b) ? a - b : Math.abs(a) - Math.abs(b))//merge sort but there is strategy that detect number of elements where it might choose quick sort with double pivot
	    .mapToInt(i -> i)//(int)i
	    .toArray();
	    
	    //implement a working sort
	    
	  }
	  
	  public static int getMinDiff(int[] A) {
		    Arrays.sort(A);
		    int size = A.length;
		    int[] temp = new int[size];
		    int left = 0;
		    int right = size - 1;
		    int index = 0;
		    while(left < right) {
		      temp[left++] = A[index++];
		      temp[right--] = A[index++]; //why this always has even distribution? 
		    }
		    if(left == right) temp[left] = A[index++];
		    
		    int max = Integer.MIN_VALUE;
		    for(int i = 1; i < size; i++) {
		      max = Math.max(max, Math.abs(temp[i] - temp[i-1]));
		    }
		    max = Math.max(max, Math.abs(temp[0] - temp[size - 1]));
		    return max;
		    
		  }
}
