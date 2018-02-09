package leetcode.trees;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBST {

	/*
	 * Given a binary search tree, write a function kthSmallest to find the kth
	 * smallest element in it.
	 */

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/* O(N) time, O(N) space, where N is the number of nodes in the tree. */
	public int kthSmallest(TreeNode root, int k) {
		// Using Inorder Traversal
		List<Integer> list = new ArrayList<Integer>();
		inOrder(root, list, k);
		return list.get(k - 1);

	}

	// L P R
	public void inOrder(TreeNode root, List<Integer> list, int k) {

		if (root.left != null)
			inOrder(root.left, list, k);

		// visit the current node
		list.add(root.val);

		if (root.right != null)
			inOrder(root.right, list, k);
	}

	/*
	 * to not use space we need an integer that change and all the recursive
	 * calls see that it changed, either by using a global variable or by
	 * dealing with it as an object
	 */
	
	 
}
