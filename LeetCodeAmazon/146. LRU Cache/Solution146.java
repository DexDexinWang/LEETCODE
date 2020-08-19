import java.util.HashMap;
import java.util.Map;

public class Solution146 {

	public static void main(String[] args) {
		
	}
	class LRUCache {
	    //First,In order to get a paire result, we always consider HashMap strucutre becuase of the get time complexity
	    //Second, we want to mintian an order that will be easier to move existing node to the fornt of the structure, all add a new ement in the front of the strucutre. I prefer use a doubled linked Node structure becuase of moving cost will be O(1) and getFirst will O(1)
	    //Hence, HashMap + DLinkedList
	    
	    class DLinkedList{
	        DLinkedList prev;
	        DLinkedList next;
	        int key;  //Why it also saved key, becuase if the cache size if full, so the lastest one will be deleted. THe key will map bakc to hashMap.
	        int val;
	        DLinkedList(int key, int val) {
	            this.key = key;
	            this.val = val;
	        }
	    }
	    
	    Map<Integer, DLinkedList> map;
	    DLinkedList head;
	    DLinkedList tail;
	    int capacity; //For each put section.  
	    public LRUCache(int capacity) {
	        this.capacity = capacity;
	        head = new DLinkedList(-1,-1);
	        tail = new DLinkedList(-1,-1);
	        head.next = tail;
	        tail.prev = head;
	        map = new HashMap<>();
	    }
	    
	    public int get(int key) {
	        if(map.containsKey(key)) {
	        	moveToFirst(map.get(key),false);
	            return map.get(key).val;
	        }
	        return -1;
	    }
	    
	    private void moveToFirst(DLinkedList target, boolean isNew) {
	        if(!isNew) {
	            target.prev.next = target.next;
	            target.next.prev = target.prev;
	        }
	        DLinkedList temp = head.next;
	        target.next = temp;
	        temp.prev = target;
	        head.next = target;
	        target.prev = head;
	    }
	    
	    private DLinkedList deleteLast() {
	        DLinkedList last = tail.prev;
	        last.prev.next = last.next;
	        last.next.prev = last.prev;
	        return last;
	    }
	    
	    public void put(int key, int value) {
	        if(map.containsKey(key)) 
	        {
	            DLinkedList curr = map.get(key);
	            curr.val = value;
	            moveToFirst(curr,false);
	        } else {
	            DLinkedList node = new DLinkedList(key,value);
	            map.put(key, node);
	            moveToFirst(node,true);
	            if(map.size() > capacity) {
	                DLinkedList deletedNode = deleteLast();
	                map.remove(deletedNode.key);
	            }
	        }
	    }
	}
}
