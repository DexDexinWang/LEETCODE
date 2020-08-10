
public class TimePlanner {
/*
Time Planner
Implement a function meetingPlanner that given the availability, slotsA and slotsB, of two people and a meeting duration dur, returns the earliest time slot that works for both of them and is of duration dur. If there is no common time slot that satisfies the duration requirement, return an empty array.

Time is given in a Unix format called Epoch, which is a nonnegative integer holding the number of seconds that have elapsed since 00:00:00 UTC, Thursday, 1 January 1970.

Each person¡¯s availability is represented by an array of pairs. Each pair is an epoch array of size two. The first epoch in a pair represents the start time of a slot. The second epoch is the end time of that slot. The input variable dur is a positive integer that represents the duration of a meeting in seconds. The output is also a pair represented by an epoch array of size two.

In your implementation assume that the time slots in a person¡¯s availability are disjointed, i.e, time slots in a person¡¯s availability don¡¯t overlap. Further assume that the slots are sorted by slots¡¯ start time.

Implement an efficient solution and analyze its time and space complexities.

Examples:

input:  slotsA = [[10, 50], [60, 120], [140, 210]]
        slotsB = [[0, 15], [60, 70]]
        dur = 8
output: [60, 68]

input:  slotsA = [[10, 50], [60, 120], [140, 210]]
        slotsB = [[0, 15], [60, 70]]
        dur = 12
output: [] # since there is no common slot whose duration is 12
 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	  //Bruteforce Validate every combination of each period in slots A and  each period in slots B. 
	  //Compare situations: 
	  //A.Start > B.End || A.End < B.Start ignore
	  //B.Start<= A.start <= B.End <= A.End ==> B.End - A.Start
	  //B.Start<= A.start <= A.End <= B.End ==> A.End - A.Start
	  //A.Start<= B.start <= A.End <= B.End ==> A.End - B.Start
	  //A.Start<= B.start <= B.End <= A.End ==> B.End - B.Start
	  //IF A pair of Duration is euqal or less than dur, return [Start, dur]
	  //Time complexity will be O(m * n) where m is the length of SlotsA and n is the length of SlotsB
	  //It could be optimized by comparing the closet period. If A.End < B.End then compare B and next of A. Otherwise compare A and next of B.
	  //Time complexity will bo O(m+n)
	  static int[] meetingPlanner1(int[][] slotsA, int[][] slotsB, int dur) {
	    int currA = 0;
	    int currB = 0;
	    while(currA < slotsA.length && currB < slotsB.length) {
	      int startA = slotsA[currA][0];
	      int endA = slotsA[currA][1];
	      int startB = slotsB[currB][0];
	      int endB = slotsB[currB][1];
	      if(!(startA > endB || startB > endA)) {
	        int expectDur = 0;
	        int start = 0;
	        if(startB <= startA && startA <= endB && endB<= endA) {
	          start = startA;
	          expectDur = endB - startA;
	        } else if(startB <= startA && startA <= endA && endA <= endB) {
	          start = startA;
	          expectDur = endA - startA;
	        } else if(startA <= startB && startB <= endA && endA<= endB) {
	          start = startB;
	          expectDur = endA - startB;
	        } else if(startA <= startB && startB <= endB && endB <= endA) {
	          start = startB;
	          expectDur = endB - startB;
	        } 
	        if(expectDur <= dur) {
	          return new int[] {start, start + dur};
	        }
	        
	        if(endA < endB) {
	          currA++;
	        } else {
	          currB++;
	        }
	      }
	    }
	    return new int[]{};
	  }
	  
	  static int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
		    int currA = 0;
		    int currB = 0;
		    while(currA < slotsA.length && currB < slotsB.length) {
		    	int start = Math.max(slotsA[currA][0], slotsB[currB][0]);
		    	int end = Math.min(slotsA[currA][1], slotsB[currB][1]);

	        if (start + dur <= end) {
	            return new int[] {start, start + dur};
	          }

	        if (slotsA[currA][1] < slotsB[currB][1]){
	          currA++;
	        } else {
	          currB++;
	        }
	      }
		    return new int[] {};
	  }
}
