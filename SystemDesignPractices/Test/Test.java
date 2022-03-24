
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ListNode node = new ListNode(1);
        Test.updateValue(node); 
        System.out.println(node.val); // 2
        
        int value = 321321321;
        updateValue(value);
        System.out.println(value);  // 2 or 1?
	}

	
    
    public static void updateValue(ListNode value) {
        value.val ++;
    }
    
    public static void updateValue(int value) {
    	int newvalue = value;
        newvalue++;
    }
}


class ListNode {
     int val;
   ListNode next;
ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

