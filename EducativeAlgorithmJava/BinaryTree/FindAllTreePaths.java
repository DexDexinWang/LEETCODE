import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class FindAllTreePaths {
  public static List<List<Integer>> findPaths(TreeNode root, int sum) {
    List<List<Integer>> allPaths = new ArrayList<>();
    findPathsDFS(root, sum, new LinkedList<Integer>(), allPaths);
    return allPaths;
  }

  public static void findPathsDFS(TreeNode root, int sum, List<Integer> path, List<List<Integer>> allPaths) {
	path.add(root.val);
	sum -= root.val;
    if(root.left== null && root.right == null) {
      if(sum == 0) {
        allPaths.add(new LinkedList<>(path));
      }
    } else {
	    if(root.left != null) findPathsDFS(root.left, sum, path, allPaths);
	    if(root.right != null) findPathsDFS(root.right, sum, path, allPaths);
    }
    sum += root.val;
    path.remove(path.size() - 1);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(4);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    int sum = 23;
    List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
    System.out.println("Tree paths with sum " + sum + ": " + result);
  }
}
