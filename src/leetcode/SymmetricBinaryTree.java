package leetcode;

import java.util.LinkedList;
import java.util.Queue;
/* 
 * Given a binary tree, check whether it is a mirror of itself 
 * (ie, symmetric around its center).
 */
public class SymmetricBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/*
	 * This algorithm will work if we want to chek that every node in the tree
	 * has identical valued nodes
	 *  ex: 1 
	 *     / \ 
	 *    2   2 
	 *   / \ / \ 
	 *  3  3 4  4 
	 */
	public boolean isChildrenIdtentical(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode n = queue.remove();
			if (n.left != null && n.right != null && n.left.val != n.right.val)
				return false; // found mismatch.
			if ((n.left == null || n.right == null) && !(n.left == null && n.right == null)) return false;
			// They are equal. and not equal null?
			if (n.left != null ) {
				queue.add(n.left);
				queue.add(n.right);
			}
		}
		return true;
	}
	
	
	/*
	 * ex:   1 
	 *     / \ 
	 *    2   2 
	 *   / \ / \ 
	 *  3  4 4  3  
	 *  symmetric tree is a tree that is mirror to itself
	 *   */
	 public boolean isSymmetric(TreeNode root) {
	        if (root == null) return true;
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        queue.add(root.left);
	        queue.add(root.right);
	        while (!queue.isEmpty()) {
	            TreeNode n1 = queue.remove();
	            TreeNode n2 = queue.remove();
	            // Both are null, equal but we will not 
	            // add any thing to the queue.
	            if(n1 == null && n2 == null) continue;
	            // One of them equal null while the other not.
	            if (n1 == null || n2 == null) return false;
	            // The values are not equal.
	            if (n1.val != n2.val) return false;
	            // add n1.left, n2.right, n1.right, n2.left
	            queue.add(n1.left);
	            queue.add(n2.right);
	            queue.add(n1.right);
	            queue.add(n2.left);
	        }
	        return true;
	    }
	 
	 /* The recursive approach */
	 
	 public boolean isSymmetricI(TreeNode root) {
	        if (root == null) return true;
	        return isSymmetric(root.left, root.right);
	    }
	    
	    public boolean isSymmetric(TreeNode n1, TreeNode n2) {
	        if (n1 == null && n2 == null) return true;
	        if (n1 == null || n2 == null) return false;
	        return (n1.val == n2.val) && isSymmetric(n1.left, n2.right) && isSymmetric(n1.right, n2.left);
	    }
	
}
