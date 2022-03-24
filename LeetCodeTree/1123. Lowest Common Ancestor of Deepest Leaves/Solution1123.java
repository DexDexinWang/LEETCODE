import generator.TreeNode;

public class Solution1123 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    int currentMax =-1;
    //DFS pass height to child nodes and compare height;
    //left and right: expecting return the lowest height.
    //current: if left == right and >= global lowest height, update common node.
    //return: return lowest height.
    TreeNode lowest = null;
    int lowestHeight = 0;
    
    TreeNode maxNode = null;
    
    public int getDeepestLeaves(TreeNode root,int depth)
    {
        if(root == null)
            return -1;
        if(root.left == null && root.right == null)
        {
            if(depth>=currentMax)
            {
                currentMax = depth;
                maxNode = root;
            }
            return depth;
        }
        
        int left = getDeepestLeaves(root.left,depth+1);
        int right = getDeepestLeaves(root.right,depth+1);  
        
        if(left>0 && right>0 && left == right)
        {
            if(left>=currentMax)
            {
                currentMax = left;
                maxNode = root;
            }
        }
        return Math.max(left,right);
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) return null;
        lcaDeepestLeavesPreOrder(root, 0);
        return lowest;
    }
    public TreeNode lcaDeepestLeaves1(TreeNode root) {
        getDeepestLeaves(root,0);
        return maxNode;
    }
    
    private int lcaDeepestLeavesPreOrder(TreeNode root, int height) {
        if (root.left == null && root.right == null) {
            if (height > lowestHeight) {
                lowestHeight = height;
                lowest = root;
            }
            return height;
        } else {
            int left = root.left != null ? lcaDeepestLeavesPreOrder(root.left, height + 1) : height;
            int right = root.right != null ? lcaDeepestLeavesPreOrder(root.right, height + 1) : height;
            if (left == right && left >= lowestHeight) {
                lowestHeight = left;
                lowest = root;
            } 
            return Math.max(left, right);
            
        }
        
    }

}
