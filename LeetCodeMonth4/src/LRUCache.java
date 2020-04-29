import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache cache = new LRUCache( 2 /* capacity */ );
		cache.put(1, 1);
		cache.put(2, 2);
		cache.get(1);       // returns 1
		cache.put(3, 3);    // evicts key 2
		cache.get(2);       // returns -1 (not found)
		cache.put(4, 4);    // evicts key 1
		cache.get(1);       // returns -1 (not found)
		cache.get(3);       // returns 3
		cache.get(4);       // returns 4
	}
	
	class DLinkedList {
        DLinkedList prev;
        DLinkedList next;
        int val;
        public DLinkedList(int val) {
            this.val = val;
        }
    }

    DLinkedList head;
    DLinkedList tail;
    Map<Integer, DLinkedList> map;
    int size; 
    public LRUCache(int capacity) {
    	head = new DLinkedList(-1);
        tail = new DLinkedList(-1);
        head.next = tail;
        tail.prev = head;
        size = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            //Maintain orders
            DLinkedList node = map.get(key);
            moveNodeToFirst(node, true);
            return node.val;
        }
        return -1;
    }
    
    public void moveNodeToFirst(DLinkedList node, boolean isExist) {
        if(isExist) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    
    public void put(int key, int value) {
        DLinkedList node = new DLinkedList(value);
        if (!map.containsKey(key)) {
            moveNodeToFirst(node, false);
            if (map.size() > size) {
                deleteNode(tail.prev);
            }
        } else {
            deleteNode(map.get(key));
            moveNodeToFirst(node, false);
        }
        map.put(key, node);
    }
    
    public void deleteNode(DLinkedList node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }

}
