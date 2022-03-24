import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import generator.TreeNode;

public class Solution987 {

	class Res{
        int col;
        int row;
        int val;
        public Res(int row, int col, int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//1. BFS checks each node and calculate row index and col index and node.val
    //2. Sort by column, row, and value
    //3. Output
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        List<Res> list = new LinkedList<>();
        //1.BFS record all nodes.
        verticalTraversalBFS(root,list);
        //2.Sort
        Collections.sort(list, (l1, l2) ->{
            if(l1.col == l2.col) {
                if(l1.row == l2.row) {
                    return l1.val - l2.val;
                } else {
                    return l1.row - l2.row;
                }
            } else {
                return l1.col - l2.col;
            }
        });
        //3 output 
        List<Integer> resSubList = new LinkedList<>();
        int colIndex = list.get(0).col;
        for(Res node: list) {
            int val = node.val;
            if(node.col != colIndex) {
                res.add(resSubList);
                colIndex = node.col;
                resSubList = new LinkedList<>(); 
            }
            resSubList.add(val);
        }
        res.add(resSubList);
        
        return res;
    }
    
    private void verticalTraversalBFS(TreeNode root, List<Res> list) {
        if(root == null) return;
        Deque<Res> que = new LinkedList<>();
        Deque<TreeNode> que1 = new LinkedList<>();
        Res newRes = new Res(0,0,root.val);
        que.offerLast(newRes);
        que1.offerLast(root);
        while(!que1.isEmpty()) {
            Res temp = que.pollFirst();
            TreeNode temp1 = que1.pollFirst();
            list.add(temp);
            if(temp1.left != null) {
            	que1.offerLast(temp1.left);
            	que.offerLast(new Res( temp.row + 1, temp.col - 1, temp1.left.val));
            }
            if(temp1.right != null) {
            	que1.offerLast(temp1.right);
            	que.offerLast(new Res( temp.row + 1, temp.col + 1, temp1.right.val));
            }
        }
    }
}
