import generator.TreeNode;

public class BSTOperations {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		new BSTOperations().deleteNodeRecursion(root,3).print();
	}
	
	public TreeNode deleteNodeIteration(TreeNode root, int target) {
		TreeNode prev = null;
		TreeNode cur = root;
		
		while(cur != null) {
			if (cur.val == target) {
				break;
			} else if (cur.val > target) {
				prev = cur;
				cur= cur.left;
			} else {
				prev = cur;
				cur = cur.right;
			}
		}
		if (cur == null) return root;
		
		if(cur.left != null && cur.right != null) {
			
			if (cur.right.left == null) {
				cur.right.left = cur.left;
				if (prev == null) {
					return cur.right;
				} else {
					if (prev.val > cur.val) {
						prev.left = cur.right;
					} else {
						prev.right = cur.right;
					}
					
				}
			} else {
				TreeNode next = deleteSmallest(cur.right);
				next.left = cur.left;
				next.right = cur.right;
				if(prev == null) {
					return next;
				} else {
					if (prev.val > cur.val) {
						prev.left = next;
					} else {
						prev.right = next;
					}
				}
			}
			return root;
		} else if (cur.left == null) {
			if (prev == null) {
				return cur.right;
			} else {
				if (prev.val > cur.val) {
					prev.left = cur.right;
				} else {
					prev.right = cur.right;
				}
			}
		} else if (cur.right == null) {
			if (prev == null) {
				return cur.left;
			} else {
				if (prev.val > cur.val) {
					prev.left = cur.left;
				} else {
					prev.right = cur.left;
				}
			}
		} 
		
		return root;
	}
	
	public TreeNode deleteNodeRecursion(TreeNode root, int target) {
		if (root == null) {
			return null;
		} 
		if (root.val > target) {
			root.left = deleteNodeRecursion(root.left, target);
			return root;
		} else if (root.val < target) {
			root.right = deleteNodeRecursion(root.right, target);
			return root;
		} else {//root.val == target
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			} else {//above conditions will consider a target has one child or no child.
				//Find the smallest node in the target node`s right node.  
				if (root.right.left == null) {
					root.right.left = root.left;
					return root.right;
				} else {
					TreeNode smallest = deleteSmallest(root.right);
					smallest.left = root.left;
					smallest.right = root.right;
					return smallest;
				}
			}
		}
	}

    public TreeNode insertNodeIteration(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		} 
		if (root.val > val) {
			root.left = insertNodeIteration(root.left, val);
			return root;
		} else  {
			root.left = insertNodeIteration(root.left, val);
			return root;
		}
	}
    
	
	public TreeNode insertNodeRecursion(TreeNode root, int val) {
		TreeNode cur = root;
		TreeNode prev = null;
		while(cur != null) {
			prev = cur;
			if(cur.val > val) {
				cur = cur.left;
			} else {
				cur = cur.right;
			}
		}
		TreeNode newNode = new TreeNode(val);
		if (prev == null) {
			return newNode;
		} else {
			if (prev.val > val) {
				prev.left = newNode;
			} else {
				prev.right = newNode;
			}
		} 
		return root;
	}
	
	public TreeNode updateNodeIteration(TreeNode root, int target, int val) {
		root = deleteNodeIteration(root,target);
		root = insertNodeIteration(root,val);
		return root;
	}
	
	private TreeNode deleteSmallest(TreeNode root) {
		TreeNode leftChild = root.left;
		while(leftChild.left != null) {
			root = root.left;
			leftChild = root.left;
		}
		root.left = leftChild.right;
		leftChild.right = null;
		return leftChild;
	}
}
