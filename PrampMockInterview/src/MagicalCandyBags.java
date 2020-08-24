
public class MagicalCandyBags {

/**
Magical Candy Bags
You have N bags of candy. The ith bag contains arr[i] pieces of candy, and each of the bags is magical!
It takes you 1 minute to eat all of the pieces of candy in a bag (irrespective of how many pieces of candy are inside), and as soon as you finish, the bag mysteriously refills. If there were x pieces of candy in the bag at the beginning of the minute, then after you've finished you'll find that floor(x/2) pieces are now inside.
You have k minutes to eat as much candy as possible. How many pieces of candy can you eat?
Signature
int maxCandies(int[] arr, int K)
Input
1 ¡Ü N ¡Ü 10,000
1 ¡Ü k ¡Ü 10,000
1 ¡Ü arr[i] ¡Ü 1,000,000,000
Output
A single integer, the maximum number of candies you can eat in k minutes.
Example 1
N = 5 
k = 3
arr = [2, 1, 7, 4, 2]
output = 14
In the first minute you can eat 7 pieces of candy. That bag will refill with floor(7/2) = 3 pieces.
In the second minute you can eat 4 pieces of candy from another bag. That bag will refill with floor(4/2) = 2 pieces.
In the third minute you can eat the 3 pieces of candy that have appeared in the first bag that you ate.
In total you can eat 7 + 4 + 3 = 14 pieces of candy.



 */


  //PriorityQueue,  MaxHeap
  //Each time I will pop top and push num/2 back to the que; count the rest.
  //final return it outp 
  //Time complexity: O(n + klogk) spce O(n)
  
  //1.Sort ==> the order for all  ==> get first k elements as new array. 
  //2.Get max vaue to do sum + divide max value / 2;    
  //3.do k-1 step 2.
  //Iteratively 
  //Time O(nlogn + k) Space O(n) 
  // 
  // 20 12 5 4;     que: 10 
  // *  12 5 4;     que: 10, 6
  // *  *  5 4;     que: 6, 5
  // *  *  5 4:     que: 5  3
  // (k-1) indicates how many sort action for k elements
  
  
  public static void main(String[] args) 
  {
  }
  
  
}