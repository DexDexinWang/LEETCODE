import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution636 {

	public static void main(String[] args) {
		// ["0:start:0","0:start:2","0:end:5","1:start:7","1:end:7","0:end:8"]
		List<String> input = new LinkedList<>();
		input.add("0:start:0");
		input.add("0:start:2");
		input.add("0:end:5");
		input.add("1:start:7");
		input.add("1:end:7");
		input.add("0:end:8");
		Solution636 test = new Solution636();
		System.out.println(Arrays.toString(test.exclusiveTime(2, input)));

	}

	class Log {
		int index;
		boolean isStart;
		int time;

		public Log(int index, boolean isStart, int time) {
			this.index = index;
			this.isStart = isStart;
			this.time = time;
		}
	}

	public int[] exclusiveTime(int n, List<String> logs) {
		Map<Integer, Integer> count = new HashMap<>();
		int[] res = new int[n];
		Deque<Log> stack = new LinkedList<>();
		for(String str: logs) {
			Log curr = convertLog(str);
			if(stack.isEmpty() || stack.peek().index == curr.index && stack.peek().isStart && curr.isStart || stack.peek().index != curr.index && !(!stack.peek().isStart && curr.isStart)) {
				stack.offerLast(curr);
			} else {
				res[stack.peek().time] += curr.time - stack.pollLast().time + 1;
			}
		}
		return res;
	}

	public Log convertLog(String str) {
		int firstC = str.indexOf(':');
		int lastC = str.lastIndexOf(':');
		int index = Integer.valueOf(str.substring(0, firstC));
		boolean isStart = str.substring(firstC + 1, lastC).equals("start");
		int time = Integer.valueOf(str.substring(lastC + 1));
		return new Log(index, isStart, time);
	}
}
