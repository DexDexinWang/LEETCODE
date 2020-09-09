import java.util.*;

class InsertInterval {

	  public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	    List<Interval> mergedIntervals = new ArrayList<>();
	    int start = intervals.get(0).start  < newInterval.start ? intervals.get(0).start : newInterval.start;
	    int end = intervals.get(0).start  < newInterval.start ? intervals.get(0).end : newInterval.end;
	    boolean checkNew = intervals.get(0).start  < newInterval.start? true: false;
	    for(int i = 0; i < intervals.size();) {
	      Interval interval = intervals.get(i);
	      int tempStart = interval.start;;
	      int tempEnd = interval.end;
	      i++;
	      if(interval.start >= newInterval.start && checkNew) {
		      tempStart = newInterval.start;
		      tempEnd = newInterval.end;
		      checkNew =false;
		      i--;
	      }
	      if(end >= tempStart) {
	        end = Math.max(end, tempEnd);
	      } else {
	        mergedIntervals.add(new Interval(start,end));
	        start = tempStart;
	        end = tempEnd;
	      }
	    }
	    mergedIntervals.add(new Interval(start,end));
	    return mergedIntervals;
	  }

	  public static void main(String[] args) {
	      List<Interval> input = new ArrayList<Interval>();
	    input.add(new Interval(1, 3));
	    input.add(new Interval(5, 7));
	    input.add(new Interval(8, 12));
	    System.out.print("Intervals after inserting the new interval: ");
	    for (Interval interval : InsertInterval.insert(input, new Interval(4, 6)))
	      System.out.print("[" + interval.start + "," + interval.end + "] ");
	    System.out.println();

	    input = new ArrayList<Interval>();
	    input.add(new Interval(1, 3));
	    input.add(new Interval(5, 7));
	    input.add(new Interval(8, 12));
	    System.out.print("Intervals after inserting the new interval: ");
	    for (Interval interval : InsertInterval.insert(input, new Interval(4, 10)))
	      System.out.print("[" + interval.start + "," + interval.end + "] ");
	    System.out.println();

	    input = new ArrayList<Interval>();
	    input.add(new Interval(2, 3));
	    input.add(new Interval(5, 7));
	    System.out.print("Intervals after inserting the new interval: ");
	    for (Interval interval : InsertInterval.insert(input, new Interval(1, 4)))
	      System.out.print("[" + interval.start + "," + interval.end + "] ");
	    System.out.println();
	  }
	}
