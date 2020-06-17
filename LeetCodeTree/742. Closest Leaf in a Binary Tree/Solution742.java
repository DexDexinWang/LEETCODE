import generator.TreeNode;

public class Solution742 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		root.right.left.left = new TreeNode(6);
		root.right.right.right = new TreeNode(7);
		root.right.left.left.left = new TreeNode(8);
		root.right.left.left.right = new TreeNode(9);
		root.right.right.right.left = new TreeNode(10);
		System.out.print(new Solution742().findClosestLeaf(root, 3));
	}
	//Post Order
    //Left and Right: expeting the nearest leaf, leaf level, whether found the target, and target level. 
    //Current: if a leaf and found target, check whether the leaf is the nearest leaf. Otherwise, If found leave calculate the path from node to target. Otherwise, return the nearest leaf in current tree. 
    //Rturn: nearest leaf, leaf level, whether found the target, and target level.
	private int nearestPath; 
    private int nearestNum;
    public int findClosestLeaf(TreeNode root, int k) {
        nearestPath = Integer.MAX_VALUE;
        nearestNum = Integer.MAX_VALUE;
        if(root== null) return 0;
    	count(root, 1, k, false, 0);
    	return nearestNum;
    }
    
    private Res count(TreeNode root, int level, int k, boolean foundK, int kLevel) {
        if(root == null) return null;
        //If found K from above.
        if(root.val == k) {
            foundK = true;
            kLevel = level;
        }
        
        if(root.left == null && root.right == null && foundK) {
            int temp = Math.abs(level - kLevel);
            compareMin(temp, root.val);
        }
        
        //If found in subTree
        Res left = count(root.left, level + 1, k, foundK, kLevel);
        Res right = count(root.right, level + 1, k, foundK, kLevel);
        if (left == null && right == null) return new Res(root.val, level, foundK, kLevel);
        if (left == null || right == null) return  left == null ? right : left;
        
        if (left.findTarget == true) {
            int temp = Math.abs(right.nearestPath - level) + Math.abs(left.targetLevel - level);
            compareMin(temp, right.nearestLeaf);
        } else if (right.findTarget == true) {
            int temp = Math.abs(left.nearestPath - level) + Math.abs(right.targetLevel - level);
            compareMin(temp, left.nearestLeaf);
        } 
        if(left.nearestLeaf <right.nearestLeaf) {
            return new Res(left.nearestLeaf, left.nearestPath, foundK, kLevel);
        } else {
            return new Res(right.nearestLeaf, right.nearestPath, foundK, kLevel);
        }
    }
    
    private void compareMin(int path, int num) {
        if(path < nearestPath) {
            nearestPath = path;
            nearestNum = num;
        }
    }
    
    class Res{
        int nearestLeaf;
        int nearestPath;
        boolean findTarget;
        int targetLevel;
        public Res(int nl, int np, boolean f, int t) {
            nearestLeaf = nl;
            nearestPath = np;
            findTarget = f;
            targetLevel = t;
        }
    }
}

