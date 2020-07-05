import java.util.Deque;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution1161 {
	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//[989,null,10250,98693,-89388,null,null,null,-32127]
		TreeNode root = new TreeNode(989);
		root.right = new TreeNode(10250);
		root.right.left = new TreeNode(98693);
		root.right.right = new TreeNode(-89388);
		root.right.right.right = new TreeNode(-32127);
		System.out.println(new Solution1161().maxLevelSum(root));
	}
	
    //BFS 
    //Sum node values level by level 
    public int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 1;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        int currLevel = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            currLevel++;
            int currSum = 0;
            for(int i = 0; i < size; i++){
                TreeNode node = queue.pollFirst();
                currSum+= node.val;
                if(node.left != null) queue.offerLast(node.left);
                if(node.right != null) queue.offerLast(node.right);
            }
            if(currSum > maxSum) {
                maxSum = currSum;
                maxLevel = currLevel;
            }
        }
        return maxLevel;
    }
    //DFS
    int n = 10000;
    int[] levels = new int[n];
    
    public int maxLevelSum1(TreeNode root) {
        preOrder(root, 1);
        
        int maxId = 1;
        for (int i = 1; i < n; i++) {
            maxId = levels[maxId] < levels[i] ? i : maxId;
        }
        
        return maxId;
    }
    
    private void preOrder(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        
        levels[level] += root.val;
        preOrder(root.left, level + 1);
        preOrder(root.right, level + 1);
        
    }
}
