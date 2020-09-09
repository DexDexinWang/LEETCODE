import java.util.*;

class Job {
  int start;
  int end;
  int cpuLoad;

  public Job(int start, int end, int cpuLoad) {
    this.start = start;
    this.end = end;
    this.cpuLoad = cpuLoad;
  }
};

class MaximumCPULoad {

	public static int findMaxCPULoad(List<Job> jobs) {
	    if(jobs == null || jobs.size() == 0) {
	      return 0;
	    }
	    Collections.sort(jobs, (a,b)->(a.start == b.start ? a.end - b.end : a.start - b.start));
	    int currMaxLoad = 0;
	    int maxLoad = 0;
	    PriorityQueue<Job> min = new PriorityQueue<>((a,b)->(a.end - b.end));
	    for(Job j : jobs) {
	    	while(!min.isEmpty() && min.peek().end <= j.start) {
	    		currMaxLoad -= min.poll().cpuLoad;
	    	}
	    	min.offer(j);
	    	currMaxLoad += j.cpuLoad;
	    	maxLoad = Math.max(currMaxLoad, maxLoad);
	    }
	    return maxLoad;
	  }
	
	
  public static int findMaxCPULoad1(List<Job> jobs) {
    if(jobs == null || jobs.size() == 0) {
      return 0;
    }
    Collections.sort(jobs, (a,b)->(a.start == b.start ? a.end - b.end : a.start - b.start));
    int size = 0; 
    for(Job j: jobs) {
      size = Math.max(size, j.end);
    }
    int[] arr = new int[size+1];

    int max = 0;
    for(Job j : jobs) {
      int load = j.cpuLoad;
      for(int i = j.start ; i<=j.end; i++) {
        arr[i] = arr[i] + load;
        max = Math.max(max, arr[i]);
      }
    }
    return max;
  }

  public static void main(String[] args) {
    List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
    System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

    input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
    System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

    input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
    System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));
  }
}
