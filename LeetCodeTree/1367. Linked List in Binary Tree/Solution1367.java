import java.util.Deque;
import java.util.LinkedList;
import generator.TreeNode;

public class Solution1367 {

	public class ListNode {
		      ListNode next;
		      int val;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    private boolean res;
    public boolean isSubPath(ListNode head, TreeNode root) {
        res = false;
        isSubPath(head, root, new LinkedList<>());
        return res;
    }
    
    
    public void isSubPath(ListNode head, TreeNode root, Deque<ListNode> queue) {
        if (root == null || res) return;
        Deque<ListNode> left = new LinkedList<>();
        Deque<ListNode> right = new LinkedList<>();
        int size = queue.size();
        for(int i = 0; i < size; i++) {
            ListNode node = queue.pollFirst();
            if(root.val == node.val) {
                if(node.next == null) {
                    res = true;
                    return;
                } else {
                	ListNode next = node.next;
                    left.offerLast(next);
                    right.offerLast(next);
                }
            }
        }
        if(root.val == head.val) {
        	if(head.next == null) {
        		res = true;
        		return;
        	} else {
	        	ListNode next = head.next;
	            left.offerLast(next);
	            right.offerLast(next);
        	}
        }
        isSubPath(head, root.left, left);
        isSubPath(head, root.right, right);
    }
}
