import java.util.LinkedList;
import java.util.List;

import generator.TreeNode;

public class Solution1469 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    //PreOrder
    //Left and Right: find longly node.
    //current: if parent node has only one child, just regard current node as only node. 
    //return nothing.
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null || root.left == null && root.right == null) return res;
        getLonelyNodes(root, res, false);
        return res;
    }
    
    private void getLonelyNodes(TreeNode root, List<Integer> res, boolean isLongly) {
        if(root == null) return;
        if(isLongly) res.add(root.val);
        isLongly = root.left == null && root.right != null || root.left != null && root.right == null;
        getLonelyNodes(root.left, res, isLongly);
        getLonelyNodes(root.right, res, isLongly);
    }
    
}
