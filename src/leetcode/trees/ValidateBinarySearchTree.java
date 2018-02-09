package leetcode.trees;

public class ValidateBinarySearchTree {

	/*
	 * Given a binary tree, determine if it is a valid binary search tree (BST).
	 * 
	 * Assume a BST is defined as follows:
	 * 
	 * The left subtree of a node contains only nodes with keys less than the
	 * node's key. The right subtree of a node contains only nodes with keys
	 * greater than the node's key. Both the left and right subtrees must also
	 * be binary search trees.
	 */

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isValidBST(TreeNode root) {
		// We used Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY because
		// the root could be Integer.max or Integer.min and = is not allowed so
		// we choose a bigger value which is infinite and -ve infinity
		return isValidBSTDFS(root, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);

	}

	// DFS
	public boolean isValidBSTDFS(TreeNode root, double maximum, double minimum) {
		if (root == null)
			return true;
		if (root.val >= maximum || root.val <= minimum)
			return false;
		return isValidBSTDFS(root.left, root.val, minimum) && isValidBSTDFS(root.right, maximum, root.val);
	}

	// BFS
	public boolean isValidBSTBFS(TreeNode root, double maximum, double minimum) {
		if (root == null)
			return true;
		if (root.val >= maximum || root.val <= minimum)
			return false;
		if (root.left != null && !isValidBSTBFS(root.left, root.val, minimum))
			return false;
		if (root.right != null && !isValidBSTBFS(root.right, maximum, root.val))
			return false;
		return true;
	}

}
