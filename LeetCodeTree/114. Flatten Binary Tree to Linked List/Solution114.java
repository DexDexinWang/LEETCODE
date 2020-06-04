import generator.TreeNode;

public class Solution114 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    //left and right: return the tails for left subtree and right subt ree
    //current: if no child return nodo. Otherwise, if lefttail != null, lefttail.right = current.right; current.right = current.left; current.left == null;
    //return: return if righttail is not null otherwise return lefttail
    public void flatten(TreeNode root) {
        flattenTree(root);
    }
    
    private TreeNode flattenTree(TreeNode node) {
        if (node == null) return null;
        if(node.left == null && node.right == null) return node;
        TreeNode lt = flattenTree(node.left);
        TreeNode rt = flattenTree(node.right);
        if(lt != null) {
            lt.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        return rt == null? lt :rt;
        
    }
}
