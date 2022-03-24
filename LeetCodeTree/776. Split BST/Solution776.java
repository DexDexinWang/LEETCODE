import generator.TreeNode;

public class Solution776 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		Solution776 test = new Solution776();
		test.splitBST(root, 2);
	}
	
	public TreeNode[] splitBST(TreeNode root, int V) {
		if (root == null) return new TreeNode[] {null,null};
		if (root.val <= V) {
			TreeNode[] bns = splitBST(root.right, V);
			root.right = bns[0];
			bns[0]= root;
			return bns;
		} else {
			TreeNode[] bns = splitBST(root.left, V);
			root.left = bns[1];
			bns[1]= root;
			return bns;
		}
	}
	//1. Find most closest.
    //2. Remove the node with left subtree.
    public TreeNode[] splitBST1(TreeNode root, int V) {
        TreeNode[] res = new TreeNode[2];
        if (root == null) return res;
        
        TreeNode[] temp = findMostClost(root, V);
        TreeNode targetPrevious = temp[0];
        TreeNode target = temp[1];
        boolean isLeft = targetPrevious.left == target? true: false;
        if(targetPrevious == null) {
            res[0]=target.left;
            res[1]=target.right;
        } else {
            TreeNode[] targetSuccessorRes = findBiggerSuccessor(target);
            TreeNode targetSuccessorPrev = targetSuccessorRes[0];
            TreeNode targetSuccessor = targetSuccessorRes[1];
            if(targetSuccessor == null) {
                if(isLeft) {
                    targetPrevious.left = null;
                } else {
                    targetPrevious.right = null;
                }
            } else {
                if (targetSuccessor != null && targetSuccessorPrev != null){
                    targetSuccessor.right = target.right;    
                }
                if(isLeft) {
                    targetPrevious.left = targetSuccessor;
                } else {
                    targetPrevious.right = targetSuccessor;
                }
            } 
            res[0] =root;
            target.right = null;
            res[1] = target;
        }
        return res;
    }
    
    private TreeNode[] findBiggerSuccessor(TreeNode root) {
        if(root.right == null) return new TreeNode[]{null,null};
        if(root.right.left == null) return new TreeNode[]{null,root.right};
        TreeNode prev = root.right;
        root = root.right.left;
        
        while(root.left != null) {
            root= root.left;
            prev = root;
        }
        prev.left = null;
        return new TreeNode[]{prev,root};
    } 
    
    private TreeNode[] findMostClost(TreeNode root, int v) {
        TreeNode targetPrevious = null;
        TreeNode previous = null;
        TreeNode target = root;
        while(root != null) {
            if (Math.abs(target.val - v) > Math.abs(root.val - v)){
                target = root;
                targetPrevious = previous;
            }
            root = root.val < target.val ? root.right : root.left;
            previous = target;
        }
        return new TreeNode[]{targetPrevious, target};
    }
}
