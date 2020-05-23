import java.util.LinkedList;
import java.util.List;

import generator.TreeNode;

public class Solution894 {

	public static void main(String[] args) {
		new Solution894().allPossibleFBT(7);

	}

    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new LinkedList<>();
        if (N == 0 || N % 2 == 0) return res;
        TreeNode root = new TreeNode(0);
        generateTree(root, root, 1, N, res);
        return res;
    }
    
    public void generateTree(TreeNode root, TreeNode cur, int count, int N, List<TreeNode> res) {
    	if (count == N) {
        	res.add(root);
        }  
        cur.left = new TreeNode(0);
        cur.right = new TreeNode(0);
        count += 2;
        if (count < N) {
            generateTree(root, cur.left, count, N, res);
            generateTree(root, cur.right, count, N, res);
        }
        cur.left = null;
        cur.right = null;
    }
}
