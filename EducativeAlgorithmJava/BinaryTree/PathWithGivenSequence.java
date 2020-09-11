
public class PathWithGivenSequence {
	  public static boolean findPath(TreeNode root, int[] sequence) {
		    if(root == null) return false;
		    return findPathDFS(root, sequence, 0);
		  }

		  public static boolean findPathDFS(TreeNode root, int[] sequence, int index) {
		    if(root == null || index == sequence.length) {
		      return root == null && index == sequence.length;
		    } 
		    if(root.val != sequence[index]) return false;
		    return findPathDFS(root.left, sequence, index + 1) || findPathDFS(root.right, sequence, index + 1);
		  }
		  
		  public static void main(String[] args) {
		    TreeNode root = new TreeNode(1);
		    root.left = new TreeNode(0);
		    root.right = new TreeNode(1);
		    root.left.left = new TreeNode(1);
		    root.right.left = new TreeNode(6);
		    root.right.right = new TreeNode(5);

		    System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
		    System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
		  }
}
