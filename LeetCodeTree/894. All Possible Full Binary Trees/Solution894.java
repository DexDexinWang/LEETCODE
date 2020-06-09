import java.util.LinkedList;
import java.util.List;

import generator.TreeNode;

public class Solution894 {

	public static void main(String[] args) {
		new Solution894().allPossibleFBT(7);

	}

    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode>[] res = new LinkedList[N+1];
        res[0] = new LinkedList<>();
        res[1] = new LinkedList<>();
        if(N == 0) return res[0];
        res[0].add(null);
        res[1].add(new TreeNode(0));
        for(int i = 2; i <=N; i++) {
            res[i] = new LinkedList<TreeNode>();
            if(i % 2 == 1) {
                for(int j = 1; j < i; j=j+2) {
                    for(TreeNode left: res[j]) {
                        for(TreeNode right: res[i - j - 1]) {
                            TreeNode newNode = new TreeNode(0);
                            newNode.left = left;
                            newNode.right = clone(right);
                            res[i].add(newNode);
                        }
                    }
                }
            }
        }
        return res[N];
    }
    
    private TreeNode clone (TreeNode node) {
        if(node == null) return null;
        TreeNode n = new TreeNode(0);
        n.left = clone(node.left);
        n.right = clone(node.right);
        return n;
    }
}
