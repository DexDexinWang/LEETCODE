

import generator.TreeNode;

public class CheckIfaStringIsaValidSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckIfaStringIsaValidSequence test = new CheckIfaStringIsaValidSequence();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.left.right = new TreeNode(0);
	}

	//Each level, it wll check whether the current node is leaf, index is the last one in given array,
    //and node.vla = arr[index]
    //Each level, if current node value is the same as arr[x], it will check sub tree will has the same values as given array. 
    public boolean isValidSequence(TreeNode root, int[] arr) {
        //corner case
        if (root == null) {
            return false;
        }
        
        return processNode(root, arr, 0);
    }
    
    public boolean processNode(TreeNode root, int[] arr, int index) {
        if (index == arr.length && root.left == null && root.right == null) {
            return arr[index] == root.val;
        } else if (index == arr.length || (root.left == null && root.right == null) || root.val != arr[index]) {
            return false;
        } else {
            return (root.left != null ? processNode(root.left, arr, index +1): false) || (root.right != null ? processNode(root.right, arr, index +1): false);
        }
    }
    


	private static boolean checkPath(TreeNode root, int arr[], int index) 
	{ 
	     if(root == null || index == arr.length)
	         return false;
	     
	     if(root.left == null && root.right == null && root.val == arr[index] && index == arr.length-1)
	         return true;
	    
	     return root.val == arr[index] && (checkPath(root.left, arr, index+1) || checkPath(root.right, arr, index+1));
	
	} 
		
}
