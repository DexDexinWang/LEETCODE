/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Jun 8, 2017 6:07:29 PM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.

Example 1:
Input: Binary tree: [1,2,3,4]
       1
     /   \
    2     3
   /    
  4     

Output: "1(2(4))(3)"

Explanation: Originallay it needs to be "1(2(4)())(3()())", 
but you need to omit all the unnecessary empty parenthesis pairs. 
And it will be "1(2(4))(3)".
Example 2:
Input: Binary tree: [1,2,3,null,4]
       1
     /   \
    2     3
     \  
      4 

Output: "1(2()(4))(3)"

Explanation: Almost the same as the first example, 
except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
 */

import generator.TreeNode;
import generator.TreeRandom;

public class Solution606 {
	public static void main(String[] args) {
		TreeNode input1 = TreeRandom.treeGen(3, null);
		System.out.println(tree2str(input1));
	}
	
    public static String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        helper(sb,t);
        return sb.toString();
    }
    public static void helper(StringBuilder sb,TreeNode t){
        if(t!=null)
        {
            sb.append(t.val);
            
            if(t.left!=null||t.right!=null)
            {
                sb.append("(");
                helper(sb,t.left);
                sb.append(")");
                
                if(t.right!=null){
                    sb.append("(");
                helper(sb,t.right);
                sb.append(")");
                }
            }
        }
    }
}
