package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {

	/**
	 * Definition for a binary tree node.
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		TreeNode n = root;
		List<Integer> result = new ArrayList<Integer>();
		postorderTraversal(n, result);
		return result;
	}

	public void postorderTraversal(TreeNode node, List<Integer> result) {
		if (node == null)
			return;
		// Left.
		postorderTraversal(node.left, result);
		// Right.
		postorderTraversal(node.right, result);
		// Visit
		result.add(node.val);
	}

}
