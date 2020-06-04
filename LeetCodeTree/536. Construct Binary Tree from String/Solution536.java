import java.util.Deque;
import java.util.LinkedList;

import generator.TreeNode;

public class Solution536 {

	public static void main(String[] args) {
		 

	}

    private int index = 0;
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) return null;
        Deque<TreeNode> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        TreeNode root = new TreeNode(getNextValue(chars));
        stack.offerLast(root);
        
        while(index < chars.length) {
            char c = chars[index];
            if(c == '(') {
                index++;
            } else if ( c ==')') {
                stack.pollLast();
                index++;
            } else {
                TreeNode node = stack.peekLast();
                TreeNode newNode = new TreeNode(getNextValue(chars));
                 if(node.left == null) {
                        node.left = newNode;
                    } else {
                        node.right = newNode;
                    }
                    stack.offerLast(newNode);
            }
        }
        return root;
    }
    
    private int getNextValue(char[] chars) {
        StringBuilder sb = new StringBuilder();
        while (index < chars.length && (chars[index] == '-' || chars[index] -'0' >= 0 && chars[index] -'0' <= 9)) {
            sb.append(chars[index++]);
        }
        return Integer.parseInt(sb.toString());
    }
	
}
