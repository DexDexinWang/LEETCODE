package generator;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumSumCircularSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumSumCircularSubarray test= new MaximumSumCircularSubarray();
		test.maxSubarraySumCircular(new int[] {1,-2,3,-2});
	}
	
	//Get prefix sum to find Maximum (A[j] - A[i]) where j - A.len < i <= j 
	public int maxSubarraySumCircular(int[] A) {
        int len = A.length;
     //Get prefix sum
     int[] array = new int[2 * len];
     array[0] = A[0];
     for(int i = 1 ; i < 2*len; i++) {
     	array[i] = array[i - 1] + A[i % len];
     }
     
     Deque<Integer> deque = new LinkedList<>();
     deque.offerLast(0); // Start position 0;
     
     int maxSum = array[0];
     for(int j = 1; j < 2 * len; j++) {
     	//check j - A.len <= i < j;
     	while( j - len > deque.peekFirst()) {
     		deque.pollFirst();
     	}
     	//Get MaxSum
     	maxSum = Math.max(maxSum, array[j] -  array[deque.peekFirst()]);
     	//if i1 < i2 and array[i1] > array[i2]
     	while (!deque.isEmpty() &&array[j] <= array[deque.peekLast()]) {
     		deque.pollLast();
     	}
         deque.offerLast(j);
     }
     return maxSum;
   }
	//Kadane algorithm for 2 situations.
	//1. no circular, find max sum in A
	//2. has circular, find sum(A[0] to A[i]) + sum(A[j] to A[len - 1]) where j >=i;    ====> Sum(n=0 to k-1)(Ak) - Sum(A(i+1) to A (j-1))  ====> sum(A) + kadane(B) where B is negative of A.
	//however, it should be at least one element in result Sum(A) + kadane(B) 
}