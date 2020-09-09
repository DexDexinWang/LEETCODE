import java.util.Arrays;

public class ConflictingAppointments {

	public static boolean canAttendAllAppointments(Interval[] intervals) {
	    Arrays.sort(intervals, (a,b)->(a.start - b.start)); 
	    int start = intervals[0].start;
	    int end = intervals[0].end;
	    for(int i = 1; i < intervals.length; i++) {
	      if(end > intervals[i].start) {
	        return false;
	      } else {
	        start = intervals[i].start;
	        end = intervals[i].end;
	      }
	    }
	    return true;
	  }

	  public static void main(String[] args) {
	    Interval[] intervals = { new Interval(1, 4), new Interval(2, 5), new Interval(7, 9) };
	    boolean result = ConflictingAppointments.canAttendAllAppointments(intervals);
	    System.out.println("Can attend all appointments: " + result);

	    Interval[] intervals1 = { new Interval(6, 7), new Interval(2, 4), new Interval(8, 12) };
	    result = ConflictingAppointments.canAttendAllAppointments(intervals1);
	    System.out.println("Can attend all appointments: " + result);

	    Interval[] intervals2 = { new Interval(4, 5), new Interval(2, 3), new Interval(3, 6) };
	    result = ConflictingAppointments.canAttendAllAppointments(intervals2);
	    System.out.println("Can attend all appointments: " + result);
	  }
}
