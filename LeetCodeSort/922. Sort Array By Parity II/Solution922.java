import java.util.Arrays;

import integer.RandomInteger;

public class Solution922 {

	public static void main(String[] args) {
		int[] a = new int[] {3,1,4,2};
		sortArrayByParityII(a);
		System.out.print(Arrays.toString(a));
	}
	
	public static int[] sortArrayByParityII(int[] A) {
	    //corner cases
        if (A == null) {
            return null;
        }
        int size = A.length;
        if (size == 1) {
            return A;
        }
        //it does not make sure that array is odd event size;
        if ((size & 1) == 1) {
            return null;
        }
        
        int i = 0;
        int j = 1; 
        //all even elements in the left side of i are sorted but not A[i];
        //all odd elements in the left side of j are sorted but not A[j];
        while (i < A.length && j < A.length) {
            if (A[j] % 2 == 0 && A[i] % 2 == 1) {
            	swap(A, i, j);
            	i +=2;
            	j +=2;
            } else if (A[i] % 2 == 0) {
            	i +=2;
            } else if (A[j] % 2 == 1) {
            	j +=2;
            } else {
            	i +=2;
            	j +=2;
            }
        }
        return A;
    }
    
    private static void swap(int[] A, int i, int j) { 
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    // Time complexity: O(n);
    // Space complexity: O(1);
}
