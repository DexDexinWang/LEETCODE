import java.util.LinkedList;
import java.util.List;

import generator.TreeNode;

public class Solution366 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        findLeaves(root, res);
        return res;
    }
    
    private int findLeaves(TreeNode root, List<List<Integer>> res) {
        if (root == null) {
            return -1;
        }
        int leftHight = findLeaves(root.left,res);
        int rightHight = findLeaves(root.right,res);
        int currHeight = Math.max(leftHight, rightHight) + 1;
        List<Integer> temp;
        if (res.size() - 1 < currHeight) {
            temp = new LinkedList<>();
            res.add(currHeight, temp);
        } else {
            temp = res.get(currHeight);
        } 
        
        temp.add(root.val);
        return currHeight;
    }
}
