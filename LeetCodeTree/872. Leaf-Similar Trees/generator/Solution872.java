package generator;

import java.util.LinkedList;
import java.util.List;

public class Solution872 {
	
	public boolean leafSimilar2(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		} else if (root1 == null || root2 == null) {
			return false;
		}
		List<Integer> t1 = new LinkedList<>();
        List<Integer> t2 = new LinkedList<>();
        traverseTree(root1, t1);
        traverseTree(root2, t2);
        if (t1.size() != t2.size()) {
        	return false;
        } else {
        	return t1.equals(t2);
        }
    }
	
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> t1 = new LinkedList<>();
        List<Integer> t2 = new LinkedList<>();
        traverseTree(root1, t1);
        traverseTree(root2, t2);
        return t1.equals(t2);
    }
    
    public void traverseTree(TreeNode root, List<Integer> record) {
        if (root.left == null && root.right == null) {
            record.add(root.val);
        } 
        if (root.left != null) traverseTree(root.left, record);
        if (root.right != null) traverseTree(root.right, record);
    } 
}
