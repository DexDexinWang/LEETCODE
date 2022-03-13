import java.util.HashSet;
import java.util.Set;

import generator.TreeNode;

public class Solution1261 {

	class FindElements{
        Set<Integer> set = new HashSet<>();
        public FindElements(TreeNode root) {
            traverseTree(root, 0);
        }
        
        public boolean find(int target) {
            return set.contains(target);
        }
        
        private void traverseTree(TreeNode root, int curr) {
            if (root == null) return;
            set.add(curr);
            traverseTree(root.left, 2*curr + 1);
            traverseTree(root.right, 2*curr + 2);
        }
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
