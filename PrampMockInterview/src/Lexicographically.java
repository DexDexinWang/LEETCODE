import java.util.PriorityQueue;

public class Lexicographically {


    int[] findMinArray(int[] arr, int k) {

    int i=0;
    while(i<arr.length && k>0){
      int min_index = i;
      
      for(int j=i+1; j<=i+k && j < arr.length; j++)//k     k >>>>  n
      {
        if(arr[min_index]>arr[j])
        {
          min_index = j;
        }
      }
      
      for(int j=min_index; j>i && k>0; j--)//k....2k
      {
        int temp = arr[j];
        arr[j] = arr[j-1];
        arr[j-1] = temp;
        k--;
      }
      
      i++;
    }
    
    return arr;
    }
	  
	 public static void main(String[] args) {
	    int[] input = new int[]{8, 9, 11, 2, 1};
	    System.out.println(new Lexicographically().findMinArray(input, 6));   
	  }

}
