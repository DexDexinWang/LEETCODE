import generator.ListNode;

public class Solution707 {

	public static void main(String[] args) {
		Solution707 test = new Solution707();
		/*
		test.addAtHead(1);
		test.addAtTail(3);
		test.addAtIndex(1, 2);
		test.get(1);
		test.deleteAtIndex(1);
		test.get(1);
		*/
		
		test.addAtIndex(-1, 0);
		test.get(0);
		test.get(0);
		test.get(2);
	}
	
    private ListNode head;
    private ListNode tail;
    int size = 0;
    /** Initialize your data structure here. */
     Solution707() {
        head = null;
        tail = null;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        ListNode currNode = getNode(index);
        return currNode == null ? - 1: currNode.val;
    }
    
    public ListNode getNode(int index) {
        if (head == null || index < 0) {
            return null;
        } else {
            ListNode current = head;
            for (int curr = 0; curr < index; curr++) {
                if (current == null) {
                    return null;
                }
                current = current.next;
            }
            return current;
        }
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        if (size == 0) {
            tail = newNode;
            head = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }      
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        ListNode newNode = new ListNode(val);
        if (index == 0) {
            this.addAtHead(val);
        } else if (index >= 0 && index < size) {
            ListNode preNode = getNode(index - 1);
            newNode.next = preNode.next;
            preNode.next = newNode;
            size++;
        } else if (index == size) {
        	addAtTail(val);
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index ==0 && index < size) {
            ListNode nextNode = head.next;
            head.next =null;
            head = nextNode;
            size--;
        } else if (index > 0 && index < size - 1) {
            ListNode prevNode = getNode(index - 1);
            ListNode curr = prevNode.next;
            prevNode.next = curr.next;
            curr.next = null;
            if (index == size -1) {
                tail = prevNode;
            }
            size--;
        }
    }

}

