import generator.TreeNode;

public class Solution549 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		new Solution549().longestConsecutive(root);
	}
	
	//Left and Right: expecting the longest incresing and decresing number,
    //Current: calculate crossed path to update global longest value.
    //Return: return longest incresing and decresing number,
    int longest = 0;
    public int longestConsecutive(TreeNode root) {
        longestConsecutivePostOrder(root);
        return longest;
    }
    
    //int[0] = incresing int[1]= decreasing
    private int[] longestConsecutivePostOrder(TreeNode root) {
        if(root == null) return new int[]{0,0};
        int currIn = 1, currDe = 1;
        if(root.left != null){
            int[] left = longestConsecutivePostOrder(root.left);
            if(root.val == root.left.val + 1) {
                currDe = left[1] + 1;
            } else if (root.val == root.left.val -1) {
                currIn = left[0] + 1;
            }
        }
        
        if (root.right != null) {
            int[] right = longestConsecutivePostOrder(root.right);
            if(root.val == root.right.val + 1) {
                currDe = Math.max(currDe, right[1] + 1);
            } else if (root.val == root.right.val - 1) {
                currIn = Math.max(currIn, right[0] + 1);
            }
        }
        
        longest = Math.max(longest, currIn + currDe - 1);
        return new int[]{currIn, currDe};
    }

}
