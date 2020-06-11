import generator.TreeNode;

public class Solution988 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(4);
		new Solution988().smallestFromLeaf(root);
	}
    //PreOrder
    //Current: if current is not leaf then add value + 1. otherwise, calclate depth if depth is smaller then compare value
    String res = "~";
    public String smallestFromLeaf(TreeNode root) {
        if (root == null) return "";
        smallestFromLeaf(root, new StringBuilder());
        return res;
    }
    
    private void smallestFromLeaf(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.insert(0,(char)(root.val + 'a'));
        if(root.left == null && root.right == null) {
            String temp = sb.toString();
            if( temp.compareTo(res) <0) {
                res = temp;
            }
        }
        smallestFromLeaf(root.left, sb);
        smallestFromLeaf(root.right, sb);
        sb.deleteCharAt(0);
    }
}
