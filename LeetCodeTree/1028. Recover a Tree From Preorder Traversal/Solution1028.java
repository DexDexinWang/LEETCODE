import java.util.Deque;
import java.util.LinkedList;

import generator.TreeNode;

public class Solution1028 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new Solution1028().recoverFromPreorder("10-7--8");
	}
	
    public TreeNode recoverFromPreorder(String S) {
        if(S == null || S.length() == 0) return null;
        char[] chars = S.toCharArray();
        Deque<TreeNode> nodeStack = new LinkedList<>();
        Deque<Integer> levelStack = new LinkedList<>();
        int rootEnd = getEndIndex(chars, 0, false);
        TreeNode root = new TreeNode(Integer.parseInt(S.substring(0,rootEnd)));
        nodeStack.offerLast(root);
        levelStack.offerLast(0);
        for(int i = rootEnd; i < chars.length; i++) {
            int count = getEndIndex(chars, i, true) - i;
            i = count + i;
            int endIndex = getEndIndex(chars, i, false);
            int val = Integer.parseInt(S.substring(i,endIndex));
            i = endIndex - 1;
            while(!levelStack.isEmpty() && count <= levelStack.peekLast()) {
                levelStack.pollLast();
                nodeStack.pollLast();
            }
            TreeNode curr = nodeStack.peekLast();
            TreeNode newNode = new TreeNode(val);
            if(curr.left == null) {
                curr.left = newNode ;
            } else if (curr.right == null) {
                curr.right = newNode;
            } 
            nodeStack.offerLast(newNode);
            levelStack.offerLast(count);    
        }
        return root;
    }
    
    private int getEndIndex(char[] chars, int start, boolean isDash) {       
        int i = start;
        while(i < chars.length && (isDash && chars[i] == '-' || !isDash && chars[i] != '-')) {
            i++;
        }
        return i;
    }
}
