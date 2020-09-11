import java.util.*;

class MedianOfAStream {

  PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->(b-a));
  PriorityQueue<Integer> minHeap = new PriorityQueue<>();

  public void insertNum(int num) {
    maxHeap.offer(num);
    if(maxHeap.size() - minHeap.size() > 1) {
      minHeap.offer(maxHeap.poll());
    }
  }

  public double findMedian() {
    if(maxHeap.size() > minHeap.size()) {
      return maxHeap.peek();
    } else {
      return (double)(maxHeap.peek() + minHeap.peek()) / 2;
    }
  }

  public static void main(String[] args) {
    MedianOfAStream medianOfAStream = new MedianOfAStream();
    medianOfAStream.insertNum(3);
    medianOfAStream.insertNum(1);
    System.out.println("The median is: " + medianOfAStream.findMedian());
    medianOfAStream.insertNum(5);
    System.out.println("The median is: " + medianOfAStream.findMedian());
    medianOfAStream.insertNum(4);
    System.out.println("The median is: " + medianOfAStream.findMedian());
  }
}
