
	class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode parent;
		public TreeNode(int x)
		{
			val=x;
		}
		
		public void print()
		{
			System.out.print("(");
			System.out.print(val);
			if(left!=null)
			{
				this.left.print();
			}
			if(right!=null)
			{
				this.right.print();
			}
			System.out.print(")");
		}
	}

public class LCAPractice {
	

		/*
    							3
				5 (P)                      1
			6       2              0           8
				7      4(q)
*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		TreeNode p = new TreeNode(5);
		TreeNode q = new TreeNode(4);
		TreeNode mid = new TreeNode(2);
		q.parent = mid;
		mid.parent = p;
		p.parent = root;
		System.out.print(new LCAPractice().lowestCommonAncestor(p, q).val);
	}
	
    
    public TreeNode lowestCommonAncestor( TreeNode p, TreeNode q) {
        
        int pHeight = getHeight(p);  //  P:5   1
        int qHeight = getHeight(q);  //  Q:4   3   
        
        //when both height is the same. 
        //when same , check if they have the same parent.
        while(pHeight > qHeight)
        {
            pHeight--;
            if(p == null) return null;
            p = p.parent;
            
        }
        while(qHeight > pHeight)   //Q: 4 -> 5  Level: 3 -> 1
        {
            qHeight--;
            if(q == null) return null;
            q = q.parent;
        }                                   
        
        //Q:5   P:5   right now, just consider they are the same or not.
        while(q != null && p != null && p != q)   //go up for both.
        {
            q = q.parent;
            p = p.parent;
        }
        
        return p == q ? p : null;
    }
    
    public int getHeight(TreeNode node) {
    	int sum = 0;
    	while(node!= null) {
    		sum++;
    		node = node.parent;
    	}
    	return sum;
    }
}
