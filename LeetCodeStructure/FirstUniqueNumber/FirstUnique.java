import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class FirstUnique {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Edgar\\Desktop\\test.txt");
		  
		  BufferedReader br = new BufferedReader(new FileReader(file)); 
		  
		  String st; 
		  StringBuilder sb = new StringBuilder();
		  while ((st = br.readLine()) != null) 
		    sb.append(st);
		  List<Integer> ints = Arrays.stream(sb.toString().split(","))
			        .map(Integer::parseInt)
			        .collect(Collectors.toList());
		int[] input = new int[ints.size()];
		for(int i = 0; i < ints.size(); i++) {
			input[i] = ints.get(i);
		}
		FirstUnique test = new FirstUnique(input);
		System.out.print(test.showFirstUnique());
		test.add(28);
		test.add(346);
		test.add(268);
		test.add(927);
		System.out.print(test.showFirstUnique());
		
	}
	
	//In order to solve this problem. 3 data structures will be used to solve this problem.
    //1. Queue to record insert order
    //2. DLinkedList to record all values that only appear onece into inserted order
    //3. HashMap is used to search Unique First order in O(1) time complexity.
    class DLinkedList{
        DLinkedList prev;
        DLinkedList next;
        int val;
        public DLinkedList(int val) {
            this.val = val;
        }
    }
    
    Queue<Integer> que = new LinkedList<>();
    Map<Integer, DLinkedList> map = new HashMap<>();
    Map<Integer, Integer> counter = new LinkedHashMap<>();
    DLinkedList head = new DLinkedList(-1);
    DLinkedList tail = new DLinkedList(-1);
    
    public FirstUnique(int[] nums) {
        head.next = tail;
        tail.prev = head;
        
        for(int num: nums) {
            que.offer(num);
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> set : counter.entrySet()){
            if(set.getValue() == 1) {
                addUnique(set.getKey());
            }
        }
        
    }
    
    public int showFirstUnique() {
        return head.next.val;
    }
    
    public void add(int value) {
        que.offer(value);
        
        counter.put(value, counter.getOrDefault(value, 0) + 1);
        
        if(counter.get(value) != 1) {
            removeUnique(value);
        }else {
            addUnique(value);
        }
    }
    
    public void addUnique(int value) {
        DLinkedList node = new DLinkedList(value);
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
        map.put(value,node);
    }
    
    public void removeUnique(int value) {
    	if(map.containsKey(value)) {
	        DLinkedList removeTarget = map.get(value);
	        removeTarget.prev.next = removeTarget.next;
	        removeTarget.next.prev = removeTarget.prev;
	        removeTarget.next =null;
	        removeTarget.prev = null;
	        map.remove(value);
    	}
    }
}
