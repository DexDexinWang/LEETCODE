import java.util.*;


class LevelOrderTraversal {
  public static List<List<Integer>> traverse(TreeNext root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    Deque<TreeNext> que = new LinkedList<>();
    que.offerLast(root);
    while(!que.isEmpty()) {
      int size = que.size();
      List<Integer> temp = new LinkedList<>();
      for(int i = 0; i < size; i++) {
        TreeNext curr = que.pollFirst();
        if(curr.left != null) que.offerLast(curr.left);
        if(curr.right != null) que.offerLast(curr.right);
        temp.add(curr.val);
      }
      result.add(temp);
    }
    return result;
  }

  public static void main(String[] args) {
    TreeNext root = new TreeNext(12);
    root.left = new TreeNext(7);
    root.right = new TreeNext(1);
    root.left.left = new TreeNext(9);
    root.right.left = new TreeNext(10);
    root.right.right = new TreeNext(5);
    List<List<Integer>> result = LevelOrderTraversal.traverse(root);
    System.out.println("Level order traversal: " + result);
  }
}
