package leetcode.trees;

public class MaxTreeDepth {
	
	 /* Definition for a binary tree node.*/
	
	// O(n), O(1) space if we ignored the recursive call cost.
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
	class Solution {
	    public int maxDepth(TreeNode root) {
	        if (root == null) return 0;
	        else{ 
	            int leftDepth = maxDepth(root.left);
	            int rightDepth = maxDepth(root.right);
	            return 1 + Math.max(leftDepth, rightDepth);
	        }
	    }
	}
}
