package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	/*
	 * Given a binary tree, return the level order traversal of its nodes'
	 * values. (ie, from left to right, level by level).
	 */

	/* Definition for a binary tree node. */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null) return res;
		Queue<TreeNode> qu = new LinkedList<TreeNode>();
		qu.add(root);
		qu.add(null);
		List<Integer> list = new ArrayList<Integer>();
		while (!qu.isEmpty()) {
			TreeNode node = qu.remove();
			// Level
			if (node == null) {
				qu.add(null);
				res.add(list);
				list = new ArrayList<Integer>();
				if (!qu.isEmpty() && qu.peek() == null)
					break;
			} else {
				list.add(node.val);
				if (node.left != null) qu.add(node.left);
				if (node.right != null) qu.add(node.right);
			}
		}
		return res;
	}
}
