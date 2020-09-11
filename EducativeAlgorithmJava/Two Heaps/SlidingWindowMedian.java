import java.util.*;

class SlidingWindowMedian {

  PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->(b-a));
  PriorityQueue<Integer> minHeap = new PriorityQueue<>();

  public double[] findSlidingWindowMedian(int[] nums, int k) {
    double[] result = new double[nums.length - k + 1];
    for(int i = 0; i < nums.length; i++) {
      if(maxHeap.isEmpty() || maxHeap.peek() > nums[i]) {
        maxHeap.offer(nums[i]);
      } else {
        minHeap.offer(nums[i]);
      }
      balance();
      if(i + 1 >= k) {
        int currIndex = i + 1 - k;
        if(minHeap.size() == maxHeap.size()) {
          result[currIndex] = (double)(minHeap.peek() + maxHeap.peek()) / 2;
        } else {
          result[currIndex] = (double) maxHeap.peek();
        }

        int deleteTarget = nums[i - k  + 1];
        if(deleteTarget <= maxHeap.peek()) {
          maxHeap.remove(deleteTarget);
        } else {
          minHeap.remove(deleteTarget);
        }
        balance();
      }
    }
    return result;
  }

  private void balance() {
    if(maxHeap.size() - minHeap.size() > 1)  {
      minHeap.offer(maxHeap.poll());
    } else if (maxHeap.size() < minHeap.size()){
      maxHeap.offer(minHeap.poll());
    }
  }  

  public static void main(String[] args) {
    SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
    double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 2);
    System.out.print("Sliding window medians are: ");
    for (double num : result)
      System.out.print(num + " ");
    System.out.println();

    slidingWindowMedian = new SlidingWindowMedian();
    result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3);
    System.out.print("Sliding window medians are: ");
    for (double num : result)
      System.out.print(num + " ");
  }

}