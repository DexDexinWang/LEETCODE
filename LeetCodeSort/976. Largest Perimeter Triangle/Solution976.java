import java.util.Arrays;

import integer.RandomIntegerArray;
public class Solution976 {

	public static void main(String[] args) {
		int[] input = RandomIntegerArray.sortedArrayGen(10, 1, 10);
		System.out.println(Arrays.toString(input));
		System.out.println(largestPerimeter(input));

	}

    //S1, brute force -- try any combination of 3 numbers
    //S2, find first biggest combination in a sorted array
    //It should always applicable triangle rules. 
    public static int largestPerimeter(int[] A) {
        //corner cases
        if (A == null || A.length <= 2) {
            return 0;
        }
        //sort  
        Arrays.sort(A);
        int max = 0;
        for (int i = A.length - 1; i > 1; i --) {
            if (checkTriangle(A[i],A[i-1],A[i-2])) {
                max = A[i] + A[i-1] + A[i-2];
                break;
            }
        } 
        return max;
    }
    
    private static boolean checkTriangle(int a, int b, int c) {
        return a + b > c && a + c > b && b + c > a;
    }
}
