package leetcode.trees;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		TreeNode n = root;
		List<Integer> result = new ArrayList<Integer>();
		inorderTraversal(n, result);
		return result;
	}

	public void inorderTraversal(TreeNode node, List<Integer> result) {
		if (node == null)
			return;
		// Left.
		inorderTraversal(node.left, result);
		// Visit
		result.add(node.val);
		// Right.
		inorderTraversal(node.right, result);
	}
}
