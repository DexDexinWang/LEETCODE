import java.util.LinkedList;
import java.util.List;

import generator.TreeNode;

public class Solution113 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res= new LinkedList<>();
        List<Integer> curr = new LinkedList<>();
        pathSumInOrder(root, sum, curr, res);
        return res;
    }
    
    private void pathSumInOrder(TreeNode root, int sum, List<Integer> curr, List<List<Integer>> res) {
        if (root == null) return;
        curr.add(root.val);
        sum -= root.val;
        if(root.left == null && root.right == null && sum == 0) {
            List<Integer> list = new LinkedList<>();
            list.addAll(curr);
            res.add(list);
        }; 
        pathSumInOrder(root.left, sum, curr, res);
        pathSumInOrder(root.right, sum, curr, res);
        curr.remove(curr.size()-1);
    }

}
