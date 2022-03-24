import java.util.LinkedList;
import java.util.List;

import generator.TreeNode;

public class Solution971 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		new Solution971().flipMatchVoyage(root, new int[] {1,3,2});
	}
	int index;
    //Pre-order
    //current: if null return;  if root.val != voyage[i] the whole tree is invalid. if root.left != null && root.left.val != voyage[i+1] then add value; and pre-order right - left. otherwise pre-order left - right.
    boolean isValid;
    List<Integer> res;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        isValid = true;
        res = new LinkedList<>();
        index = 0;
        flipMathchVoyagePreOrder(root, voyage);
        if(!isValid) {
            res.clear();
            res.add(-1);
        }
        return res;
    }
    
    private void flipMathchVoyagePreOrder(TreeNode root, int[] voyage) {
        if(root == null || !isValid) return;
        if(root.val != voyage[index++]) {
            isValid = false; 
            return;
        }
        if(root.left != null && index < voyage.length && root.left.val != voyage[index]) {
            res.add(root.val);
            flipMathchVoyagePreOrder(root.right, voyage);
            flipMathchVoyagePreOrder(root.left, voyage);
        } else {
        	flipMathchVoyagePreOrder(root.left, voyage);
        	flipMathchVoyagePreOrder(root.right, voyage);
        }
    }
}
